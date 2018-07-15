// import state from './state'

export default {
  setUserInfo (context, userInfo) {
    context.commit('SET_USERINFO', userInfo)
  },
  delUserInfo (context) {
    context.commit('DEL_USERINFO')
  },
  setIsValidTime (context, isValidTime) {
    context.commit('SET_ISVALIDTIME', isValidTime)
  }
}
