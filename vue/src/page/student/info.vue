<template>
  <div class="stuinfo">
    <div class="info info-border">
      <div class="info-top">
        <span><i class="el-icon-setting"></i> 个人信息 </span>
        <el-button
        type="primary"
        size="mini"
        icon="el-icon-edit"
        @click="haddleupdate()">修改密码</el-button>
      </div>
      
      <div class="info-item">学号: {{userInfo.jzxId}}</div>
      <div class="info-item">姓名: {{userInfo.jzxName}}</div>
      <div class="info-item">性别: {{userInfo.jzxSex}}</div>
      <div class="info-item">年龄: {{userInfo.jzxAge}}</div>
      <div class="info-item">生源地: {{userInfo.jzxAdress}}</div>
      <div class="info-item">总学分: {{userInfo.jzxAllscore}}</div>
      <div class="info-item">任课老师: {{userInfo.jzxTeachername}}</div>
      <div class="info-item">班级编号: {{userInfo.jzxClassid}}</div>
    </div>

    <el-dialog title="修改密码" :visible.sync="dialogFormVisible">
      <el-form :model="form">
        <el-form-item label="密码" :label-width="formLabelWidth">
          <el-input v-model="form.jzxPassword" auto-complete="off"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="dialogUpdate()">保存修改</el-button>
      </div>
    </el-dialog>
  </div>
  
</template>

<script>
  export default {
    computed: {
    },
    methods: {
      haddleupdate(){
        this.form.jzxPassword = ''
        this.dialogFormVisible = true
      },
      dialogUpdate () {
        let params = new URLSearchParams()
        params.append('jzxStudentid', localStorage.getItem('id'))
        params.append('jzxPassword', this.form.jzxPassword)
        this.$http.post('/studentaccount/update', params)
          .then(response => {
            this.loading = false
            if (response.status !== 200 || response.data === 0) {
              this.$alert( '失败', {
                confirmButtonText: '确定'
              })
              return
            }
            this.dialogFormVisible = false // 关闭dialog框
            this.$message({
              message: '修改操作完成',
              type: 'success'
            })
          })
          .catch(error => {
            this.loading = false
            console.log('fail' + error)
            this.$notify.error({
              title: '错误',
              message: '网络连接错误,请检查网络状态或联系管理员.'
            })
          })
      },
      getUserInfo () {
        let params = new URLSearchParams()
        params.append('id', localStorage.getItem('id'))
        this.$http.post('/student/select', params)
          .then(response => {
            this.loading = false
            if (response.data === '') {
              this.$alert('发生错误', '错误', {
                confirmButtonText: '确定'
              })
              return
            }
            const {jzxId = '',
              jzxName = '',
              jzxSex = '',
              jzxAge = '',
              jzxAdress = '',
              jzxAllscore = '',
              jzxTeachername = '',
              jzxClassid =''} = response.data
            this.userInfo = {
                 jzxId,
                jzxName,
                jzxSex,
                jzxAge,
                jzxAdress,
                jzxAllscore,
                jzxTeachername,
                jzxClassid
            }
            localStorage.setItem('classid',jzxClassid)
          })
          .catch(error => {
            this.loading = false
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
        userInfo: {
          jzxId: '',
          jzxName: '',
          jzxSex: '',
          jzxAge: '',
          jzxAdress: '',
          jzxAllscore: '',
          jzxTeachername: '',
          jzxClassid:''
        },
        form: {
          jzxPassword: ''
        },
        resultData: [],
        dialogFormVisible: false, // 控制dialog的显示
        formLabelWidth: '50px' // dialog框大小
      }
    },
    created () {
      this.getUserInfo()
    }
  }
</script>

<style scoped>
.stuinfo{
  display: -webkit-flex; /* Safari */
  display: flex;
  align-items: flex-start;
  justify-content: space-between;
  flex-wrap: wrap;
}
.info-border{
  border: 1px solid #ebebeb;
  border-radius: 3px;
  transition: .2s;
  padding: 20px;
  margin-bottom: 30px;
}
.info-border:hover{
  box-shadow: 0 0 8px 0 rgba(232, 237, 250, .6), 0 2px 4px 0 rgba(232, 237, 250, .5);
}
.info{
  width: 100%;
  /* height: 100px; */
}
.info-top{
  display: -webkit-flex; /* Safari */
  display: flex;
  justify-content: space-between;
}
.info-item{
  margin-top: 10px;
}
.result{
  width: 100%;
  /* height: 100px; */
}
</style>