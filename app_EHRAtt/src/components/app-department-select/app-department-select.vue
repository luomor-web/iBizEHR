<template>
  <div class="app-department-select">
    <ibiz-select-tree  :NodesData="Nodesdata" v-model="selectTreeValue" :multiple="multiple" @select="onSelect"></ibiz-select-tree>
  </div>
</template>

<script lang="ts">
import { Vue, Component, Watch, Prop, Model } from 'vue-property-decorator';

@Component({
})
export default class AppDepartmentSelect extends Vue {

    /**
     * 接口url
     *
     * @type {*}
     * @memberof AppDepartmentSelect
     */
    @Prop() public url?: any;

    /**
     * 过滤项
     *
     * @type {*}
     * @memberof AppDepartmentSelect
     */
    @Prop() public filter?: any;

    /**
     * 过滤项
     *
     * @type {*}
     * @memberof AppDepartmentSelect
     */
    @Prop() public fillMap?: any;

    /**
     * 是否多选
     *
     * @type {*}
     * @memberof AppDepartmentSelect
     */
    @Prop({default:false}) public multiple?: any;

    /**
     * 表单数据
     *
     * @type {*}
     * @memberof AppDepartmentSelect
     */
    @Prop() public data!: any;

    /**
     * 上下文变量
     *
     * @type {*}
     * @memberof AppDepartmentSelect
     */
    @Prop() public context!: any;

    /**
     * 选中数值
     *
     * @type {*}
     * @memberof AppDepartmentSelect
     */
    public selectTreeValue:any = "";

    /**
     * 树节点数据
     *
     * @type {*}
     * @memberof AppDepartmentSelect
     */
    public Nodesdata: any[] = [];

    /**
     * 当前树节点数据的url
     *
     * @type {*}
     * @memberof AppDepartmentSelect
     */
    public oldurl: any[] = [];

    /**
     * 获取节点数据
     *
     * @memberof AppDepartmentSelect
     */
    public handleFilter(){
      if(this.filter){
          if(this.data && this.data[this.filter]){
            return this.data[this.filter];
          }else if(this.context && this.context[this.filter]){
            return this.context[this.filter];
          }
      }else{
          return this.context.srforgid;
      }
    }

    /**
     * 获取节点数据
     *
     * @memberof AppDepartmentSelect
     */
    public searchNodesData(){
      // 处理过滤参数，生成url
      let param = this.handleFilter();
      let _url = this.url.replace('${orgid}',param)
      if(this.oldurl === _url){
          return;
      }
      this.oldurl = _url;
      // 缓存机制
      const result:any = this.$store.getters.getCopyData(_url);
      if(result){
        this.Nodesdata = result;
        return;
      }
      this.$http.get(_url).then((response: any) => {
          this.Nodesdata = response.data;
          this.$store.commit('addDepData', { srfkey: this.filter, orgData: response.data });
      }).catch((response: any) => {
          if (!response || !response.status || !response.data) {
              this.$Notice.error({ title: '错误', desc: '系统异常！' });
              return;
          }
      });
    }

    /**
     * 值变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof AppDepartmentSelect
     */
    @Watch('data',{immediate:true,deep:true})
    public onValueChange(newVal: any, oldVal: any) {
        if(newVal){
          this.computedSelectedData();
          this.$nextTick(()=>{
            this.searchNodesData();
          });
        }
    }

    /**
     * 计算选中值
     * 
     * @memberof AppOrgSelect
     */
    public computedSelectedData(){
      // 单选
      if(!this.multiple){
        if(this.fillMap && Object.keys(this.fillMap).length >0){
        let templateValue = {};
        Object.keys(this.fillMap).forEach((item:any) =>{
          if(this.data && this.data[this.fillMap[item]]){
            Object.assign(templateValue,{[item]:this.data[this.fillMap[item]]});
          }
        })
        this.selectTreeValue = JSON.stringify([templateValue]);
        }
      }else{
      // 多选
        if(this.fillMap && Object.keys(this.fillMap).length >0){
          let tempArray:Array<any> = [];
          Object.keys(this.fillMap).forEach((item:any) =>{
            if(this.data && this.data[this.fillMap[item]]){
              let tempDataArray:Array<any> = (this.data[this.fillMap[item]]).split(",");
              tempDataArray.forEach((tempData:any,index:number) =>{
                if(tempArray.length < tempDataArray.length){
                  let singleData:any ={[item]:tempData};
                  tempArray.push(singleData);
                }else{
                  Object.assign(tempArray[index],{[item]:tempData});
                }
              })
            }
          })
          this.selectTreeValue = JSON.stringify(tempArray);
          }
      }
    } 

    /**
     * select事件处理
     * 
     * @param {*} $event
     * @memberof AppDepartmentSelect
     */
    public onSelect($event:any){
        // 组件自身抛值事件
        let selectArr = JSON.parse($event);
        // fillMap抛值事件
        if(this.fillMap && Object.keys(this.fillMap).length > 0){
            Object.keys(this.fillMap).forEach((attribute:string) => {
                let _name = this.fillMap[attribute];
                let values = selectArr.map((item:any) => item[attribute]);
                let _value = $event === "[]" ? null : values.join(",");
                this.$emit('select-change',{name: this.fillMap[attribute], value: _value})
            });
        }
    }
}
</script>

<style lang='less'>
@import './app-department-select.less';
</style>