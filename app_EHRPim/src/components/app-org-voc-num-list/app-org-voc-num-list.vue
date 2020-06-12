<template>
    <div class="app-org-voc-num-list">
        <div class="title">职业资格</div>
        <el-table border stripe
          ref="multipleTable"
          :data="items"
          style="height:calc(100% - 52px);overflow-y:auto;"
          @row-click="rowClick($event)"
          @row-dblclick="rowDBLClick($event)"
          :show-header="false">
              <el-table-column :width="zsmcStyleWidth">
                <template slot-scope="scope">
                  <span>{{ scope.row.zsmc }}</span>
                </template>
              </el-table-column>
              <el-table-column>
                <template slot-scope="scope">
                  <div style="width:100%;height:13px">
                  <div :style="{width:scope.row.countnum*100/maxCountNum+'%',backgroundColor:color16(),height:'100%'}" ></div>
                  </div>
                </template>
              </el-table-column>
              <el-table-column width="100px">
                <template slot-scope="scope">
                  <div class="column-countnum">
                    <span>{{ scope.row.countnum }}人</span>
                  </div>
                </template>
              </el-table-column>
        </el-table>
    </div>
</template>

<script lang="ts">
import { Vue, Component, Prop, Emit, Watch, } from 'vue-property-decorator';

@Component({
})
export default class AppOrgVocNumList extends Vue {
    
    /**
     * 数据
     *
     * @type {any[]}
     * @memberof AppOrgVocNumList
     */
    @Prop() protected items!: any[];

    /**
     * 选择数据
     * @memberof AppOrgVocNumList
     *
     */
    protected rowClick(args: any) {
        this.$emit('click', args);
    }

    /**
     * 双击数据
     * @memberof AppOrgVocNumList
     *
     */
    protected rowDBLClick(args: any) {
        this.$emit('dblclick', args);
    }

    /**
     * zsmc文字列宽度
     *
     * @type {any[]}
     * @memberof AppOrgVocNumList
     */
    protected zsmcStyleWidth:string = "100px";

    /**
     * 最大计数
     *
     * @type {any[]}
     * @memberof AppOrgVocNumList
     */
    protected maxCountNum:number = 0;

    /**
     * 计算随机颜色
     * @memberof AppOrgVocNumList
     *
     */
    protected color16(){
      let colorarr=["#a960e3","#6daad5","#56b337","#8662b3","#c51285","#e734ff","#e6d82d","#7e2238","#f97cf4","#dc236e","#5820cc"];
			let randomNum = Math.floor(Math.random()*11);
			return colorarr[randomNum];
		}

    /**
     * 生命周期初始化方法
     * @memberof AppOrgVocNumList
     *
     */
    created(){
        let maxCount = 0;
        let zsmcWidth = 10;
        if(this.items){
          this.items.forEach((item:any)=>{
              maxCount = item.countnum > maxCount ? item.countnum : maxCount;
              zsmcWidth = item.zsmc.length > zsmcWidth ? item.zsmc.length : zsmcWidth;
          });
        }
        this.zsmcStyleWidth = zsmcWidth*16+"px";
        this.maxCountNum = maxCount;
        
    }
}
</script>

<style lang='less'>
@import './app-org-voc-num-list.less';
</style>