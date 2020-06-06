<template>
  <div class="app-actionbar">
    <div class="app-actionbar-item" v-for="(item,index) in items" :key="index">
      <Badge v-if="item.counterService&&item.counterService.counterData" :count="item.counterService.counterData[item.counterId]" type="primary">
         <i-button @click="handleClick(item.viewlogicname)">{{item.actionName}}</i-button>
    </Badge>
    <i-button v-else @click="handleClick(item.viewlogicname)">{{item.actionName}}</i-button>
    </div>
  </div>
</template>

<script lang="ts">
import { Vue, Component, Prop, Model, Emit } from "vue-property-decorator";
import { Subject } from "rxjs";

@Component({})
export default class AppActionBar extends Vue {

  /**
   * 传入操作栏模型数据
   * 
   * @type {any}
   * @memberof AppActionBar
   */
  @Prop() public items!:any;

  /**
   * 触发界面行为
   * 
   * @memberof AppActionBar
   */
  public handleClick($event:any){
    this.$emit('itemClick',$event);
  }


}
</script>

<style lang='less'>
@import "./app-actionbar.less";
</style>