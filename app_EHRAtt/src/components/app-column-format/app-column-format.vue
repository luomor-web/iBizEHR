<template>
  <div class="app-column-format">
      {{text}}
  </div>
</template>

<script lang="ts">
import { Vue, Component, Prop, Model, Emit, Watch } from "vue-property-decorator";

/**
 * 表格列格式化json数组，数据格式为"[{"srfkey":"001","srfmajortext":"TEST1"},{"srfkey":"002","srfmajortext":"TEST2"}......]"
 */
@Component({
})
export default class AppColumnFormat extends Vue {
    
    /**
     * 值
     * @type {any}
     * @memberof AppColumnFormat
     */
    @Prop() public value?: any;

    /**
     * 显示文本
     * @type {any}
     * @memberof AppColumnFormat
     */
    get text(){
      if(this.value){
        let returnStr:string = "";
        let tempData:Array<any> =[];
        if(typeof(this.value) === 'string'){
          tempData= JSON.parse(this.value);
        }else{
          tempData = JSON.parse(JSON.stringify(this.value));
        }
        tempData.forEach((item:any,index:number) =>{
          if(index >0){
            returnStr +="、";
          }
          returnStr +=item.srfmajortext;
        })
        return returnStr;
      }else{
        return "";
      }
    }




}
</script>

<style lang='less'>
@import "./app-column-format.less";
</style>