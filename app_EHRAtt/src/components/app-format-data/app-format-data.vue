<template>
  <span class="app-format-data">
    {{getcurValue()}}
  </span>
</template>
<script lang = 'ts'>
import { Component, Vue, Prop } from 'vue-property-decorator';
import moment from "moment"; 
@Component({})
export default class AppFormatData extends Vue {

  /**
   * 格式化正则
   *
   * @type {string}
   * @memberof AppFormatData
   */
  @Prop({default:'YYYY-MM-DD HH:mm:ss'}) public format?:string;

  /**
   * 类型格式
   *
   * @type {string}
   * @memberof AppFormatData
   */
  @Prop() public dataType?:string;

  /**
   * 精度
   *
   * @type {string}
   * @memberof AppFormatData
   */
  @Prop({default:'2'}) public precision?:string;

  /**
   * 传入数据
   *
   * @type {*}
   * @memberof AppFormatData
   */
  @Prop() public data!:any;

  /**
   * 显示值
   *
   * @memberof AppFormatData
   */
  getcurValue(){
    if(this.data){
      if(Object.is(this.dataType,"DECIMAL") || Object.is(this.dataType,"FLOAT") || Object.is(this.dataType,"CURRENCY")){
        let number = Number(this.data);
        let precision = Number(this.precision);
        if(Object.is(number,NaN)){
          return this.data;
        }else{
          let result = "";
          if(Object.is(this.dataType,"CURRENCY")){
              result = Number(number.toFixed((Object.is(precision,NaN) ? 2 : precision))).toLocaleString('en-US');
          }else{
              result = number.toFixed((Object.is(precision,NaN) ? 2 : precision));
          }
          let index = result.indexOf(".");
          let fornum = (Object.is(precision,NaN) ? 2 : precision) - result.length + index + 1;
          if(Object.is(index,-1) && !Object.is(precision,0)){
            result += ".";
          }
          for (let i = 0; i < fornum; i++) {
            result += '0';
            
          }
          return result;
        } 
      } else if (this.format){
        if(this.format.indexOf('%1$t') !== -1){
          return moment(this.data).format("YYYY-MM-DD HH:mm:ss");
        }else{
          return moment(this.data).format(this.format);
        }
      }else{
        return this.data;
      }
    }else{
      return "";
    }
  }

}
</script>
<style lang="less">
@import './app-format-data.less';
</style>