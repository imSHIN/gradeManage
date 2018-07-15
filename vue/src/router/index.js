import Vue from 'vue'
import Router from 'vue-router'
// import HelloWorld from '@/components/HelloWorld'
import home from '@/components/home'
import userInfo from '@/page/userInfo'
import login from '@/page/login'
import adminStuInfo from '@/page/admin/studentInfo.vue'
import adminTeacherInfo from '@/page/admin/teacherInfo.vue'
import uploadstu from '@/page/admin/uploadstu.vue'
import uploadteah from '@/page/admin/uploadteah.vue'
import studentAccount from '@/page/admin/studentAccount.vue'
import teacherAccount from '@/page/admin/teacherAccount.vue'
import adressInfo from '@/page/admin/adressInfo.vue'

// const home = r => require.ensure([], () => r(require('../page/home/home')), 'home')

// Student page
import updataMorality from '@/page/student/updataMorality.vue'
import updataSocialPracAbili from '@/page/student/updataSocialPracAbili.vue'
import updataInnovation from '@/page/student/updataInnovation.vue'
import updataSocialWork from '@/page/student/updataSocialWork.vue'
import mark from '@/page/student/mark.vue'
import stuinfo from '@/page/student/info.vue'
import course from '@/page/student/course.vue'
import stuscore from '@/page/student/score.vue'
// teacher page
import info from '@/page/teacher/info.vue'
import avg from '@/page/teacher/avg.vue'
import teach from '@/page/teacher/teach.vue'
import scoreorder from '@/page/teacher/scoreorder.vue'
import score from '@/page/teacher/score.vue'
Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      component: login // 登陆界面
    },
    {
      path: '/home',
      component: home,
      children: [
        {
          path: '/',
          component: userInfo // 个人信息
        },
        {
          path: 'mark',
          component: mark
        },
        {
          path: 'updataMorality', // 德育素质
          component: updataMorality
        },
        {
          path: 'updataSocialPracAbili',   // 社会实践能力
          component: updataSocialPracAbili
        },
        {
          path: 'updataInnovation',    // 创新创业能力
          component: updataInnovation
        },
        {
          path: 'updataSocialWork',   // 社会工作
          component: updataSocialWork
        }
      ]
    },
    {
      path: '/teacher',
      component: home,
      children: [
        {
          path: '/',
          component: info // 个人信息
        },
        {
          path: 'avg',
          component: avg // 所有学生信息
        },
        {
          path: 'teach', // 批量上传学生账号
          component: teach
        },
        {
          path: 'scoreorder', // 设置申报时间
          component: scoreorder
        }, {
          path: 'score', // 设置申报时间
          component: score
        }
      ]
    },
    {
      path: '/student',
      component: home,
      children: [
        {
          path: '/',
          component: stuinfo
        },
        {
          path: 'course',
          component: course
        }, {
          path: 'scorecheck', // 设置申报时间
          component: stuscore
        }
      ]
    },
    {
      path: '/admin',
      component: home,
      children: [
        {
          path: '/',
          component: adminStuInfo
        },
        {
          path: 'students', // 所有学生信息
          component: adminStuInfo
        },
        {
          path: 'teachers', // 所有老师信息
          component: adminTeacherInfo
        },
        {
          path: 'uploadteah', // 批量上传老师账号
          component: uploadteah
        },
        {
          path: 'uploadstu', // 批量上传学生账号
          component: uploadstu
        },
        {
          path: 'studentAccount',
          component: studentAccount
        },
        {
          path: 'teacherAccount',
          component: teacherAccount
        },
        {
          path: 'adressInfo',
          component: adressInfo
        }
      ]
    }
  ]
})
