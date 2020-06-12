<template>
    <div class="app-org-p-num">
        <img class="orgname-log" src="/img/orgpnum/logo3.png"/>
        <span class="orgname-text">{{items[0].orgname}}</span>
        <img class="orgnum-log" src="/img/orgpnum/logo4.png" />
        <div class="count-container">
          <span class="countnum">{{items[0].countnum}}</span><br/>
          <span class="couttext">员工总数</span>
        </div>
    </div>
</template>

<script lang="ts">
import { Vue, Component, Prop, Emit, Watch, } from 'vue-property-decorator';

@Component({
})
export default class AppOrgPNum extends Vue {
    
    /**
     * 数据
     *
     * @type {any[]}
     * @memberof OrgPNum
     */
    @Prop() protected items!: any[];


}
</script>

<style lang='less'>
@import './app-org-p-num.less';
</style>