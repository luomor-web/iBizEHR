<template>
  <div id='app'>
    <debug-actions/>
    <router-view v-if="isRouterAlive"/>
  </div>
</template>
+<script lang='ts'>
import { Vue, Component, Provide } from 'vue-property-decorator';
import store from '@/store';
import { LoadAppData } from '@/utils';

@Component({
    
})
export default class App extends Vue  {

  /**
   *  控制视图是否显示
   */
  public isRouterAlive:boolean = false;

  /**
   *  向后代注入加载行为
   */
  @Provide()
  public reload = this.viewreload;

  /**
   *  vue生命周期
   */
  public created(){
    this.loadAppData();
  }

  /**
   *  视图重新加载
   */
  public viewreload () {
      this.isRouterAlive = false;
      this.$nextTick(function () {
          this.isRouterAlive = true;
      }) 
  }

  /**
   *  视图加载代码表
   */
  public async loadAppData(){
    const _store:any = store;
    if(_store.state && _store.state.codelists && _store.state.codelists.length >0){
      this.isRouterAlive = true;
      return;
    }else{
      await LoadAppData.getInstance().load(store);
      this.isRouterAlive = true;
    }
  }
 
}
</script>
<style lang='less'>
@import './styles/default.less';
</style>

