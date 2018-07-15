<template>
  <div class="sidebar">
    <el-menu :default-active="onRoutes" class="el-menu-vertical-demo" router>
      <template v-for="(item,k) in items"> <!-- vue2.20以上规定要bind key, 所以这里的k只为符合标准，并没有用到 -->
        <template v-if="item.subs">
          <el-submenu :index="item.index" :key="k">
            <template slot="title"><i :class="item.icon"></i>{{ item.title }}</template>
            <el-menu-item v-for="(subItem,i) in item.subs" :key="i" :index="subItem.index">{{ subItem.title }}
            </el-menu-item>
          </el-submenu>
        </template>
        <template v-else>
          <el-menu-item :index="item.index" :key="k">
            <i :class="item.icon"></i>{{ item.title }}
          </el-menu-item>
        </template>
      </template>
    </el-menu>
  </div>
</template>

<script>
  import { mapGetters } from 'vuex'

  export default {
    data () {
      return {
        items: []
        // items: [
        //   {
        //     icon: 'el-icon-menu',
        //     index: 'readme',
        //     title: '自述'
        //   },
        //   {
        //     icon: 'el-icon-menu',
        //     index: '2',
        //     title: '表格',
        //     subs: [
        //       {
        //         index: 'basetable',
        //         title: '基础表格'
        //       },
        //       {
        //         index: 'vuetable',
        //         title: 'Vue表格组件'
        //       }
        //     ]
        //   },
        //   {
        //     icon: 'el-icon-date',
        //     index: '3',
        //     title: '表单',
        //     subs: [
        //       {
        //         index: 'baseform',
        //         title: '基本表单'
        //       },
        //       {
        //         index: 'vueeditor',
        //         title: '编辑器'
        //       },
        //       {
        //         index: 'markdown',
        //         title: 'markdown'
        //       },
        //       {
        //         index: 'upload',
        //         title: '文件上传'
        //       }
        //     ]
        //   },
        //   {
        //     icon: 'el-icon-star-on',
        //     index: 'basecharts',
        //     title: '图表'
        //   },
        //   {
        //     icon: 'el-icon-upload2',
        //     index: 'drag',
        //     title: '拖拽'
        //   }
        // ]
      }
    },
    computed: {
      onRoutes () {
        return this.$route.path.replace('/', '')
      }
    },
    created () {
      const status = localStorage.getItem('status')
      if (status === '管理员'){
        this.items = [
          {
            icon: 'el-icon-menu',
            index: '/admin/students',
            title: '学生信息'
          },
          {
            icon: 'el-icon-menu',
            index: '/admin/teachers',
            title: '教师信息'
          },
          {
            icon: 'el-icon-menu',
            index: '/admin/teacherAccount',
            title: '教师账号信息'
          },
          {
            icon: 'el-icon-menu',
            index: '/admin/studentAccount',
            title: '学生账号信息'
          },
          {
            icon: 'el-icon-menu',
            index: '/admin/adressInfo',
            title: '统计生源信息'
          }
        ]
      } else if (status === '教师'){
        this.items = [
          {
            icon: 'el-icon-menu',
            index: '/teacher',
            title: '个人信息'
          },
          {
            icon: 'el-icon-menu',
            index: '/teacher/avg',
            title: '课程平均成绩'
          },
          {
            icon: 'el-icon-menu',
            index: '/teacher/score',
            title: '输入成绩'
          },
          {
            icon: 'el-icon-menu',
            index: '/teacher/teach',
            title: '任课信息'
          },
          {
            icon: 'el-icon-menu',
            index: '/teacher/scoreorder',
            title: '成绩名次'
          }
        ]
      } else if (status === '学生') {
        this.items = [
          {
            icon: 'el-icon-menu',
            index: '/student',
            title: '个人信息'
          },
          {
            icon: 'el-icon-menu',
            index: '/student/course',
            title: '所有课程'
          },
          {
            icon: 'el-icon-menu',
            index: '/student/scorecheck',
            title: '成绩查询'
          }
        ]
      }
    }
  }
</script>

<style scoped>
  .sidebar{
    display: block;
    position: absolute;
    width: 250px;
    left: 0;
    top: 70px;
    bottom:0;
    background: #2E363F;
  }
  .sidebar > ul {
    height:100%;
  }
</style>
