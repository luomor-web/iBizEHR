<template>
    <div class="appAddressSelection">
        <el-cascader
            :disabled="disabled"
            size ="medium"
            v-model="CurrentVal"
            :options="city">
        </el-cascader>
    </div>
</template>

<script lang='ts'>
import { Component, Vue, Prop, Model, Watch } from 'vue-property-decorator';
import { Subject } from 'rxjs';
import { debounceTime, distinctUntilChanged } from 'rxjs/operators';
import axios from 'axios';
@Component({})
export default class AppAddressSelection extends Vue {

 /**
   * 传入值
   * @type {any}
   * @memberof AppAddressSelection
   */
  @Prop() public value?:any;

  /**
   * 是否禁用
   * @type {boolean}
   * @memberof AppAddressSelection
   */
  @Prop() public disabled?: boolean;


  /**
   * 当前值
   *
   * @memberof AppAddressSelection
   */
  get CurrentVal() {
        return this.value;
  }

 /**
   * 值变化
   *
   * @memberof AppAddressSelection
   */
  set CurrentVal(val: any) {
      this.$emit("change", val); 
  }

 /**
   * 城市数据
   *
   * @memberof AppAddressSelection
   */
    public city :any = [];

 /**
   * 获取城市数据
   *
   * @memberof AppAddressSelection
   */
    public  getcity() {
            axios.get("../../assets/json/city_code.json").then((response: any) => {
            this.format(response.data);
            }).catch((response: any) => {
                console.log("城市数据加载失败");
            });


    }
    /**
   * 生命周期
   *
   * @memberof AppAddressSelection
   */
    public created() {
        this.getcity();
    }

 /**
   * 数据格式化
   *
   * @memberof AppAddressSelection
   */
    public format(data :any) {
        let data1 = JSON.parse(JSON.stringify(data).replace(/city/g, 'children')) 
        let data2 = JSON.parse(JSON.stringify(data1).replace(/name/g, 'label')) 
        let data3 = JSON.parse(JSON.stringify(data2).replace(/area/g, 'children')) 
        let data4 = JSON.parse(JSON.stringify(data3).replace(/code/g, 'value')) 
        this.city = data4;
    }
    
}
</script>

<style lang='less'>
@import './app-address-selection.less';
</style>