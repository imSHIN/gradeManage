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
      label="课程编号">
    </el-table-column>
    <el-table-column
      prop="jzx_name"
      label="课程名称">
    </el-table-column>
    <el-table-column
      prop="jzx_exam"
      label="考试方式">
    </el-table-column>
    <el-table-column
      prop="jzx_schoolitem"
      label="时间">
    </el-table-column>
    <el-table-column
      prop="jzx_teachername"
      label="教师姓名">
    </el-table-column>
    <el-table-column
      prop="jzx_score"
      label="学分">
    </el-table-column>
    <el-table-column
      prop="jzx_hour"
      label="学时">
    </el-table-column>
    <el-table-column
      prop="AVG(jzx_score)"
      label="平均分">
    </el-table-column>
    </el-table>
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
      // 搜索按钮
      handleSearch (content = '') {
        this.getStudentsInfo(this.search)
      },
      getStudentsInfo (search = '') {
        let params = new URLSearchParams()
        params.append('id', search)
        axios.post('/score/queryavg', params)
          .then(response => {
            if (response.status !== 200) {
              this.$alert( '错误', {
                confirmButtonText: '确定'
              })
              return
            }
            this.studentData = [response.data] || undefined // 把得到的数据返回给studentData给表格显示
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
        dialogFormVisible: false, // 控制dialog的显示
        dialogAddVisible: false, // 控制添加用户的dialog的显示
        formLabelWidth: '120px', // dialog框大小
        search: ''
      }
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
