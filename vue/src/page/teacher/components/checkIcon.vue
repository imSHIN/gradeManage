<template>
    <div>
        <span v-if="value == true" style="color: #67C23A"><i class="el-icon-check"></i></span> 
        <span v-else-if="value == false" style="color: #F56C6C"><i class="el-icon-close"></i></span>
        <span v-else-if="value == 'certi'" style="color: #303133">待审核</span>
        <span v-else-if="value == 'certing'" style="color: #E6A23C">审核中</span>
        <span v-else-if="value == 'certed'" style="color: #67C23A">已审核</span>
    </div>
</template>

<script>
    export default {
      props: {
        value: [Boolean, String]
      }
    }
</script>

<style scoped>

</style>