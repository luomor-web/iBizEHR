<template>
  <div class="app-org-select">
    <ibiz-select-tree :NodesData="NodesData" v-model="selectTreeValue" :multiple="multiple" @select="treeSelectChange"></ibiz-select-tree>
  </div>
</template>
<script lang = 'ts'>
import { Vue, Component, Prop, Watch } from "vue-property-decorator";
import { Http } from '@/utils';
@Component({})
export default class AppOrgSelect extends Vue {

  /**
   * 表单数据
   * 
   * @memberof AppOrgSelect
   */
  @Prop() public data!:any;

  /**
   * 上下文
   * 
   * @memberof AppOrgSelect
   */
  @Prop() public context!:any;

  /**
   * 填充对象
   * 
   * @memberof AppOrgSelect
   */
  @Prop() public fillMap:any;

  /**
   * 过滤项
   * 
   * @memberof AppOrgSelect
   */
  @Prop() public filter?:string;

  /**
   * 是否多选
   * 
   * @memberof AppOrgSelect
   */
  @Prop({default:false}) public multiple?:boolean;

  /**
   * 查询单位路径
   * 
   * @memberof AppOrgSelect
   */
  @Prop() public url!:string;

  /**
   * 监听表单数据变化
   * 
   * @memberof AppOrgSelect
   */
  @Watch('data',{immediate:true,deep:true})
  onDataChange(newVal: any, oldVal: any) {
    if(newVal){
      this.computedSelectedData();
      if(this.filter){
        let tempFilterValue:any = this.initBasicData();
        // filter值变化才去请求数据
        if(tempFilterValue && (this.copyFilterValue !== tempFilterValue)){
          this.loadTreeData(this.url.replace('${orgid}',tempFilterValue));
          this.copyFilterValue = tempFilterValue;
        }
      }
    }
  }

  /**
   * 选择值
   * 
   * @memberof AppOrgSelect
   */
  public selectTreeValue:any = "";

  /**
   * 树节点数据
   * 
   * @memberof AppOrgSelect
   */
  public NodesData:any = [];

  /**
   * 备份过滤值
   * 
   * @memberof AppOrgSelect
   */
  public copyFilterValue:any;

  /**
   * vue生命周期
   * 
   * @memberof AppOrgSelect
   */
  public created(){
    if(!this.filter){
      this.loadTreeData(this.url);
    }
  }

  /**
   * 加载树数据
   * 
   * @memberof AppOrgSelect
   */
  public initBasicData(){
    // 计算出过滤值
    if(this.filter){
      if(this.data && this.data[this.filter]){
        return this.data[this.filter];
      }else if(this.context && this.context[this.filter]){
        return this.context[this.filter];
      }else{
        return null;
      }
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
   * 加载树数据
   * 
   * @memberof AppOrgSelect
   */
  public loadTreeData(requestUrl:string){
    if(this.filter){
      const result:any = this.$store.getters.getCopyData(this.filter);
      if(result){
        this.NodesData = result;
        return;
      }
    }
    Http.getInstance().get(requestUrl).then((res:any) =>{
      if(!res.status && res.status !== 200){
        console.error("加载数据失败");
        return;
      }
      this.NodesData = res.data;
      if(this.filter){
        this.$store.commit('addOrgData', { srfkey: this.filter, orgData: res.data });
      }
    })
  }

  /**
   * 树选择触发事件
   * 
   * @memberof AppOrgSelect
   */
  public treeSelectChange($event:any){
    // 多选
    if(this.multiple){
      if(!Object.is($event,'[]')){
        const tempValue:any = JSON.parse($event);
        if(this.fillMap && Object.keys(this.fillMap).length >0){
          Object.keys(this.fillMap).forEach((item:any) =>{
            let tempResult:any ="";
            tempValue.forEach((value:any,index:number) =>{
              tempResult += index>0?`,${value[item]}`:`${value[item]}`;
            })
            this.emitValue(this.fillMap[item],tempResult);
          })
        }
      }else{
        if(this.fillMap && Object.keys(this.fillMap).length >0){
          Object.keys(this.fillMap).forEach((item:any) =>{
            this.emitValue(this.fillMap[item],null);
          })
        }
      }
    }else{
      // 单选
      if(!Object.is($event,'[]')){
        const tempValue:any = JSON.parse($event)[0];
        if(this.fillMap && Object.keys(this.fillMap).length >0){
          Object.keys(this.fillMap).forEach((item:any) =>{
            this.emitValue(this.fillMap[item],tempValue[item]);
          })
        }
      }else{
        if(this.fillMap && Object.keys(this.fillMap).length >0){
          Object.keys(this.fillMap).forEach((item:any) =>{
            this.emitValue(this.fillMap[item],null);
          })
        }
      }
    }
  }

  /**
   * 抛值
   * 
   * @memberof AppOrgSelect
   */
  public emitValue(name:string,value:any){
    this.$emit('select-change',{name:name,value:value});
  }

}
</script>

<style lang="less">
@import "./app-org-select.less";
</style>