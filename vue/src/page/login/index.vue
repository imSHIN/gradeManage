<template>
  <div class="login-wrap">
    <div class="ms-title">高校成绩管理系统</div>
    <div class="ms-login">
      <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="0px" class="demo-ruleForm">
        <el-radio v-model="radio" label="管理员">管理员</el-radio>
        <el-radio v-model="radio" label="教师">教师</el-radio>
        <el-radio v-model="radio" label="学生">学生</el-radio>
        <el-form-item prop="username">
          <el-input v-model="ruleForm.username" placeholder="username"></el-input>
        </el-form-item>
        <el-form-item prop="password">
          <el-input type="password" placeholder="password" v-model="ruleForm.password" @keyup.enter.native="submitForm('ruleForm')"></el-input>
        </el-form-item>
        <div class="login-btn">
          <el-button type="primary" @click="submitForm('ruleForm')">登录</el-button>
        </div>
      </el-form>
    </div>
  </div>
</template>

<script>
  // import {setStore} from '@/config/localStorage'
  import axios from 'axios'
  export default {
    data: function () {
      return {
        ruleForm: {
          username: '',
          password: ''
        },
        rules: {
          username: [
            { required: true, message: '请输入用户名', trigger: 'blur' }
          ],
          password: [
            { required: true, message: '请输入密码', trigger: 'blur' }
          ]
        },
        radio: '学生'
      }
    },
    methods: {
      submitForm (formName) {
        const self = this
        let url
        if (this.radio === '学生') url = '/studentaccount/login'
        else if (this.radio === '教师') url = '/teacheraccount/login'
        else if (this.radio === '管理员') url = '/adminaccount/login'
        else return
        localStorage.setItem('status', this.radio)
        self.$refs[formName].validate((valid) => {
          if (valid) {
            localStorage.setItem('id', self.ruleForm.username)
            let params = new URLSearchParams()
            if (this.radio === '学生') {
              params.append('jzxStudentid', self.ruleForm.username)
              params.append('jzxPassword', self.ruleForm.password)
            }else if (this.radio === '教师') {
              params.append('jzxTeacherid', self.ruleForm.username)
              params.append('jzxPassword', self.ruleForm.password)
            }else if (this.radio === '管理员') {
              params.append('jzxId', self.ruleForm.username)
              params.append('jzxPassword', self.ruleForm.password)
            }
            axios.post(url, params)
              .then(response => {
                console.log(JSON.stringify(response))
                if (response.data === 0) {
                  this.$alert( '密码错误', '密码错误', {
                    confirmButtonText: '确定'
                  })
                  return
                } else if (response.data !== 1) {
                  this.$alert('发生未知错误', '错误', {
                    confirmButtonText: '确定'
                  })
                  return
                }
                if (this.radio === '学生') {
                  this.$router.push('/student')
                }else if (this.radio === '教师') {
                  this.$router.push('/teacher')
                }else if (this.radio === '管理员') {
                  this.$router.push('/admin/students')
                }
              })
              .catch(error => {
                this.$alert('发生未知错误', '错误', {
                  confirmButtonText: '确定'
                })
              })
          } else {
            this.$alert('发生未知错误', '错误', {
              confirmButtonText: '确定'
            })
            return false
          }
        })
      }
    }
  }
</script>

<style scoped>
  .login-wrap{
    position: relative;
    width:100%;
    height:100%;
  }
  .ms-title{
    position: absolute;
    top:50%;
    width:100%;
    margin-top: -230px;
    text-align: center;
    font-size:30px;
    color: #fff;
  }
  .ms-login{
    position: absolute;
    left:50%;
    top:50%;
    width:300px;
    height:160px;
    margin:-150px 0 0 -190px;
    padding:40px;
    border-radius: 5px;
    background: #fff;
  }
  .login-btn{
    text-align: center;
  }
  .login-btn button{
    width:100%;
    height:36px;
  }
</style>