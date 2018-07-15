<template>
    <div>
        <p class="title"><span><i class="el-icon-tickets"></i> 公示成绩（如有误，请立即联系相关人员）</span></p> 

        <div class="border">
            <el-form>
                <el-form-item label="绩点：">
                    <p>{{GPA}}</p>
                </el-form-item>
                <el-form-item label="体育素质：">
                    <p>平均体育成绩： {{physical}}</p>
                </el-form-item>
                <el-form-item label="班级等级分：">
                    <p>{{morality.classLevel}}</p>
                </el-form-item>
                <el-form-item label="寝室纪实分：">
                    <p>{{morality.domi}}</p>
                </el-form-item>
                <el-form-item label="违纪记录：">
                    <el-table :data="badTable" style="width: 80%;">
                        <el-table-column
                        fixed
                        prop="probation"
                        label="留校察看次数">
                        </el-table-column>
                        <el-table-column
                        prop="demerit"
                        label="记过次数">
                        </el-table-column>
                        <el-table-column
                        prop="seriousAdmonish"
                        label="严重警告次数">
                        </el-table-column>
                        <el-table-column
                        prop="admonish"
                        label="警告次数">
                        </el-table-column>
                        <el-table-column
                        prop="criticismSc"
                        label="通报批评（校级）">
                        </el-table-column>
                        <el-table-column
                        prop="criticismCo"
                        label="通报批评（院级）">
                        </el-table-column>
                    </el-table>
                </el-form-item>
                <el-form-item label="英语四六级：">
                    <span>{{CET}}</span>
                </el-form-item>
                <el-form-item label="早晚出勤率：">
                    <p>{{clock.total}}</p>
                </el-form-item>
                <el-form-item label="校志愿者工时：">
                    <p>{{clock.total}}</p>
                </el-form-item>
            </el-form>
            <el-button type="primary" @click="test()"> 测试</el-button>
        </div>
    </div>
</template>

<script>
import axios from 'axios'
import { mapGetters } from 'vuex'
export default {
  data () {
    return {
      GPA: 0,
      physical: 0,
      morality: {
        classLevel: 0,
        domi: {
          total: 0,
          dormitoryWeek: 0,
          dormitoryRadio: 0,
          dormitoryPraiseNum: 0,
          dormitoryDisciplineNum: 0
        }
      },
      obey: {
        probation: 0,
        demerit: 0,
        seriousAdmonish: 0,
        admonish: 0,
        criticismSc: 0,
        criticismCo: 0,
        praise: [],  // 有专门项目对象
        certi: true,
        info: ''
      },
      CET: {
        name: '英语六级',
        point: 600
      },
      volunteerIn: 0,
      clock: {   // 打卡
        total: 0,
        first: 0,          // 上学期
        last: 0
      }
    }
  },
  computed: {
    badTable () {
      return [{ probation: this.obey.probation,
        demerit: this.obey.demerit,
        seriousAdmonish: this.obey.seriousAdmonish,
        admonish: this.obey.admonish,
        criticismSc: this.obey.criticismSc,
        criticismCo: this.obey.criticismCo}]
    },
    ...mapGetters({user: 'UserInfo'})
  },
  methods: {
    getMark () {
      const self = this
      axios.get('user/getImportedScore/' + self.user._id)
          .then(response => {
            if (response.data.status === 1 || response.data.status === 2) {
              this.$alert(response.data.statusInfo.message || '错误', {
                confirmButtonText: '确定'
              })
            } else if (response.data.status !== 0) {
              this.$alert(response.data.statusInfo.message || '发生未知错误', '错误', {
                confirmButtonText: '确定'
              })
            }
            console.log(response.data.importedScore)
            self.GPA = response.data.importedScore.GPA
            self.physical = response.data.importedScore.physical
            self.morality = response.data.importedScore.morality
            self.obey = response.data.importedScore.obey
            self.CET = response.data.importedScore.CET
            self.volunteerIn = response.data.importedScore.volunteerIn
            self.clock = response.data.importedScore.clock
          })
          .catch(error => {
            console.log('fail' + error)
            this.$notify.error({
              title: '错误',
              message: '网络连接错误,请检查网络状态或联系管理员.'
            })
          })
    },
    test () {
      console.log(this.morality)
    }
  },
  created () {
    this.getMark()
  }
}
</script>

<style scoped>
@import url('../../../static/css/commom.css');
.border {
    border: 1px solid #ebebeb;
    border-radius: 3px;
    transition: 0.2s;
    padding: 20px;
    margin-bottom: 30px;
    width: 90%;
  }
  .border:hover {
    box-shadow: 0 0 8px 0 rgba(232, 237, 250, 0.6),
      0 2px 4px 0 rgba(232, 237, 250, 0.5);
  }
  .title {
    margin-bottom: 30px;
    color: #303133;
    font-size: 20px;
  }
  .h2 {
    margin-bottom: 16px;
    font-size: 16px;
  }
</style>