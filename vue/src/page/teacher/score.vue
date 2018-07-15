<template>
  <section>
    <section class="top">
        <el-input placeholder="请输入课程编号" v-model="search" class="input-with-select" style="width:350px">
          <el-button slot="append" icon="el-icon-search" @click="handleSearch(search)"></el-button>
        </el-input>
    </section>
    <el-table
    :data="studentData"
    style="width: 100%">
    <el-table-column
      prop="jzx_id"
      label="学号">
    </el-table-column>
    <el-table-column
      prop="jzx_name"
      label="姓名">
    </el-table-column>
    <el-table-column
      prop="jzx_sex"
      label="性别">
    </el-table-column>
    <el-table-column
      prop="jzx_age"
      label="年龄">
    </el-table-column>
    <el-table-column
      prop="jzx_classid"
      label="班级编号">
    </el-table-column>
    <el-table-column
      prop="jzx_score"
      label="分数">
    </el-table-column>
    <el-table-column
      label="操作"
      width="180">
    <template slot-scope="scope">
      <el-button
        size="mini"
        @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
    </template>
    </el-table-column>
    </el-table>

    <el-dialog title="输入分数" :visible.sync="dialogFormVisible">
      <el-form :model="form">
        <el-form-item label="分数" :label-width="formLabelWidth">
          <el-input v-model="form.jzx_score" auto-complete="off"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="dialogUpdate()">保存修改</el-button>
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
      handleSearch (content = '') {
        this.getStudentsInfo(this.search)
      },
      // 点击编辑
      handleEdit (index, rowInfo) {
        if (rowInfo.jzx_score !== ''){
          this.$message({
              message: '已经录入成功,无法修改',
              type: 'success'
            })
            return
        }
        this.dialogFormVisible = true // 显示dialog框
        console.log(index, rowInfo)
        const {jzx_id= '',
          jzx_name= '',
          jzx_sex= '',
          jzx_age= '',
          jzx_classid= '',
          jzx_score= '',} = rowInfo
        this.form = {
          jzx_id,
          jzx_score
        }
      },
      // 点击保存修改信息
      dialogUpdate () {
        // console.log('tade_id')
        // this.$message('正在提交学生信息修改操作')
        // put提交)
        let params = new URLSearchParams()
        params.append('jzxStudentid', this.form.jzx_id)
        params.append('jzxScore', this.form.jzx_score)
        params.append('jzxCourseid', this.search)
        axios.post('/score/insert', params)
          .then(response => {
            if (response.status !== 200 && response.data !== 1) {
              this.$alert( '错误', {
                confirmButtonText: '确定'
              })
              return
            }
            // 添加成功 调用函数获取新数据
            this.getStudentsInfo(this.search) // 提交成功重新加载信息
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
      getStudentsInfo (search='') {
        let params = new URLSearchParams()
        params.append('teacherid', localStorage.getItem('id'))
        params.append('scoreid', search)
        axios.post('/score/enterscore/'+localStorage.getItem('id')+'/'+search, params)
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
          jzx_id: '',
          jzx_name: '',
          jzx_sex: '',
          jzx_age: '',
          jzx_classid: '',
          jzx_score: '',
        },
        dialogFormVisible: false, // 控制dialog的显示
        dialogAddVisible: false, // 控制添加用户的dialog的显示
        formLabelWidth: '120px', // dialog框大小
        condition: {}, // 筛选参数
        skipto: 0, // 翻页参数
        limit: 10, // 翻页参数
        currentPage: 1, // 当前页数
        totalPage: 0, // 总共有多少条学生信息
        sortby: '-_id', // 排序参数
        search: ''
      }
    },
    computed: {
    },
    created () {
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
