<template>
  <section>
    <section class="top">
      <el-button
        class="addOneBtm"
        size="mini"
        type="primary"
        @click="handleAddOne()">添加</el-button>
    </section>
    <el-table
    :data="studentData"
    style="width: 100%">
    <el-table-column
      prop="jzxStudentid"
      label="学号">
    </el-table-column>
    <el-table-column
      prop="jzxPassword"
      label="密码">
    </el-table-column>
    <el-table-column
      label="操作"
      width="180">
    <template slot-scope="scope">
      <el-button
        size="mini"
        @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
      <el-button
        size="mini"
        type="danger"
        @click="handleDelete(scope.$index, scope.row)">删除</el-button>
    </template>
    </el-table-column>
    </el-table>

    <el-dialog title="学生信息" :visible.sync="dialogFormVisible">
      <el-form :model="form">
        <el-form-item label="学号" :label-width="formLabelWidth">
          <el-input v-model="form.jzxStudentid" auto-complete="off"></el-input>
        </el-form-item>
        <el-form-item label="密码" :label-width="formLabelWidth">
          <el-input v-model="form.jzxPassword" auto-complete="off"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="dialogUpdate()">保存修改</el-button>
      </div>
      
    </el-dialog>
    <el-dialog title="学生信息" :visible.sync="dialogAddVisible">
      <el-form :model="add" >
        <el-form-item label="学号" :label-width="formLabelWidth">
          <el-input v-model="add.jzxStudentid" auto-complete="off"></el-input>
        </el-form-item>
        <el-form-item label="密码" :label-width="formLabelWidth">
          <el-input v-model="add.jzxPassword" auto-complete="off"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogAddVisible = false">取 消</el-button>
        <el-button type="primary" @click="dialogAdd()">添 加</el-button>
      </div>
    </el-dialog>
  </section>
</template>

<style>
  .el-table .warning-row {
    background: oldlace;
  }
  .el-table .success-row {
    background: #f0f9eb;
  }
</style>

<script>
  import axios from 'axios'
  export default {
    methods: {
      // 点击添加一条用户信息
      handleAddOne () {
        this.add = {
          jzxStudentid: '',
          jzxPassword: ''
        }
        this.dialogAddVisible = true
      },
      // 点击添加一条学生信息dialog里的添加按钮
      dialogAdd () {
        let params = new URLSearchParams()
        params.append('jzxStudentid', this.add.jzxStudentid)
        params.append('jzxPassword', this.add.jzxPassword)
        axios.post('/studentaccount/insert', params)
          .then(response => {
            if (response.status !== 200 && response.data !== 1) {
              this.$alert( '错误', {
                confirmButtonText: '确定'
              })
              return
            }
            this.dialogAddVisible = false // 关闭dialog框
            this.getStudentsInfo() // 调用函数获取数据
            this.$message({
              type: 'success',
              message: '添加成功!'
            })
          })
          .catch(error => {
            console.log('fail' + error)
            this.$notify.error({
              title: '错误',
              message: '网络连接错误,请检查网络状态或联系管理员.'
            })
          })
      },
      // 点击编辑
      handleEdit (index, rowInfo) {
        this.dialogFormVisible = true // 显示dialog框
        console.log(index, rowInfo)
        const {jzxStudentid = '',
          jzxPassword = ''} = rowInfo
        this.form = {
          jzxStudentid,
          jzxPassword
        }
      },
      // 点击删除
      handleDelete (index, rowInfo) {
        // console.log(index, rowInfo)
        this.$confirm('此操作将删除该用户信息, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => { // 点击确定
        let params = new URLSearchParams()
        params.append('id', rowInfo.jzxStudentid)
          axios.post('/studentaccount/delete/',params)
            .then(response => {
              if (response.status !== 200 && response.data !== 1) {
              this.$alert( '错误', {
                confirmButtonText: '确定'
              })
              return
            }
              // 删除后重新获取一遍数据
              this.getStudentsInfo()
              this.$message({
                type: 'success',
                message: '删除成功!'
              })
            })
            .catch(error => {
              console.log('fail' + error)
              this.$notify.error({
                title: '错误',
                message: '网络连接错误,请检查网络状态或联系管理员.'
              })
            })
        }).catch(() => { // 点击取消后事件
        })
      },
      // 点击保存修改信息
      dialogUpdate () {
        // console.log('tade_id')
        // this.$message('正在提交学生信息修改操作')
        // put提交
        let params = new URLSearchParams()
        params.append('jzxStudentid', this.form.jzxStudentid)
        params.append('jzxPassword', this.form.jzxPassword)
        axios.post('/studentaccount/update/', params)
          .then(response => {
            if (response.status !== 200 && response.data !== 1) {
              this.$alert( '错误', {
                confirmButtonText: '确定'
              })
              return
            }
            // 添加成功 调用函数获取新数据
            this.getStudentsInfo() // 提交成功重新加载信息
            this.dialogFormVisible = false // 关闭dialogu
            this.$message({
              message: '学生信息修改操作完成',
              type: 'success'
            })
          })
          .catch(error => {
            console.log('fail' + error)
            this.$notify.error({
              title: '错误',
              message: '网络连接错误,请检查网络状态或联系管理员.'
            })
          })
      },
      // 从服务器获得所有学生信息(分页)
      // condition为搜索条件
      // skipto为从哪条数据开始返回
      // limit返回几条数据
      // sortby表示排序的字段 默认_id降序
      getStudentsInfo () {
        axios.post('/studentaccount/selectall')
          .then(response => {
            if (response.status !== 200) {
              this.$alert( '错误', {
                confirmButtonText: '确定'
              })
              return
            }
            this.studentData = response.data || undefined // 把得到的数据返回给studentData给表格显示
          })
          .catch(error => {
            console.log('fail' + error)
            this.$notify.error({
              title: '错误',
              message: '网络连接错误,请检查网络状态或联系管理员.'
            })
          })
      }
    },
    data () {
      return {
        studentData: [], // 后台返回的信息用数组保存
        form: { // dialog框参数
          jzxStudentid: '',
          jzxPassword: ''
        },
        add: { // 添加用户dialog框参数
          jzxStudentid: '',
          jzxPassword: ''
        },
        dialogFormVisible: false, // 控制dialog的显示
        dialogAddVisible: false, // 控制添加用户的dialog的显示
        formLabelWidth: '120px', // dialog框大小
      }
    },
    computed: {
    },
    created () {
      this.studentData = this.getStudentsInfo() // 页面渲染成功调用函数从数据库获取信息
    }
  }
</script>

<style scoped>
.top{
  display: -webkit-flex; /* Safari */
  display: flex;
  align-items: flex-start;
  justify-content: space-between;
  flex-wrap: wrap;
}
.pagination{
  display: -webkit-flex; /* Safari */
  display: flex;
  justify-content: center;
}
</style>
