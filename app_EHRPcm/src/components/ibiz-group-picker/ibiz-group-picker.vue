<template>
    <div class="ibiz-group-picker">
        <div class="ibiz-group-container">
            <div v-if="showTree" class="ibiz-group-tree">
                <ibiz-select-tree :NodesData="treeItems" v-model="treeSelectVal" :treeOnly="true" :defaultChecked="true" @select="treeSelect"></ibiz-select-tree>
            </div>
            <div class="ibiz-group-content">
                <ibiz-group-card :data="cardItems" text="label" value="id" groupName="group" :multiple="multiple" :defaultSelect="cardSelctVal" @select="groupSelect"></ibiz-group-card>
            </div>
        </div>
        <div class="ibiz-group-footer">
            <el-button size="small" type="primary" @click="onOK">确认</el-button>
            <el-button size="small" @click="onCancel">取消</el-button>
        </div>
    </div>
</template>

<script lang="ts">
import { Component, Vue, Prop, Watch } from 'vue-property-decorator';
import { Subject } from 'rxjs';
import { Http } from '../../utils';

@Component({})
export default class IBizGroupPicker extends Vue {

    /**
     * 视图上下文参数
     *
     * @type {*}
     * @memberof IBizGroupPicker
     */  
    @Prop() viewdata: any;

    /**
     * 视图参数
     *
     * @type {*}
     * @memberof IBizGroupPicker
     */  
    @Prop() viewparam: any;

    /**
     * 多选
     *
     * @type {*}
     * @memberof IBizGroupPicker
     */  
    protected multiple: boolean = false;

    /**
     * 加载树url
     *
     * @type {*}
     * @memberof IBizGroupPicker
     */  
    protected treeurl:any;

    /**
     * 加载人员url
     *
     * @type {*}
     * @memberof IBizGroupPicker
     */  
    protected url:any;

    /**
     * 树数据集
     *
     * @type {*}
     * @memberof IBizGroupPicker
     */  
    protected treeItems: any[] = [];

    /**
     * 分组表数据集
     *
     * @type {*}
     * @memberof IBizGroupPicker
     */  
    protected cardItems: any[] = [];

    /**
     * 视图上下文参数对象
     *
     * @type {*}
     * @memberof IBizGroupPicker
     */  
    protected viewData: any;

    /**
     * 视图参数对象
     *
     * @type {*}
     * @memberof IBizGroupPicker
     */  
    protected viewParam: any;

    /**
     * 树选中值
     *
     * @type {*}
     * @memberof IBizGroupPicker
     */  
    protected treeSelectVal: string = '';

    /**
     * 分组表选中集合
     *
     * @type {*}
     * @memberof IBizGroupPicker
     */  
    protected cardSelctVal: any = [];

    /**
     * 数据选中集合
     *
     * @type {*}
     * @memberof IBizGroupPicker
     */  
    protected selects: any[] = [];

    /**
     * 是否显示树
     *
     * @type {*}
     * @memberof IBizGroupPicker
     */  
    get showTree() {
        if(this.viewParam) {
            return this.viewParam.showtree;
        }
    }

    /**
     * 生命周期
     *
     * @type {*}
     * @memberof IBizGroupPicker
     */  
    public created() {
        if(!this.viewdata || !this.viewparam) {
            return;
        }
        this.viewData = JSON.parse(this.viewdata);
        this.viewParam = JSON.parse(this.viewparam);
        this.multiple = this.viewParam.multiple;
        this.treeurl = this.viewParam.treeurl;
        this.url = this.viewParam.url;
        if (this.viewParam.selects) {
            this.viewParam.selects.forEach((select: any) => {
                this.selects.push(select);
                this.cardSelctVal.push(select.id)
            })
        }
        this.load();
    }

    /**
     * 加载数据
     *
     * @type {*}
     * @memberof IBizGroupPicker
     */  
    public load() {
        if(this.showTree) {
            this.loadTree();
        } else {
            this.loadGroupData(this.viewParam.filtervalue);
        }
    }

    /**
     * 加载树数据
     *
     * @type {*}
     * @memberof IBizGroupPicker
     */  
    public loadTree() {
        let orgid = this.viewParam.filtervalue;
        let tempTreeUrl:string = this.treeurl.replace('${orgid}',orgid);
        let get = Http.getInstance().get(tempTreeUrl, true);
        get.then((response: any) => {
            if(response.status === 200) {
                this.treeItems = response.data;
            }
        }).catch((error: any) => {
            console.log(error)
        })
    }

    /**
     * 加载分组表数据
     *
     * @type {*}
     * @memberof IBizGroupPicker
     */  
    public loadGroupData(key: string) {
        let tempUrl = this.url.replace('${selected-orgid}',key);
        let get = Http.getInstance().get(tempUrl, true);
        get.then((response: any) => {
            if(response.status === 200) {
                this.cardItems = response.data;
            }
        }).catch((error: any) => {
            console.log(error)
        })
    }

    /**
     * 树选中
     *
     * @type {*}
     * @memberof IBizGroupPicker
     */  
    public treeSelect(event: any) {
        if(!event || JSON.parse(event).length == 0) {
            return;
        }
        const items: any = JSON.parse(event);
        this.loadGroupData(items[0].id);
    }

    /**
     * 分组表选中
     *
     * @type {*}
     * @memberof IBizGroupPicker
     */  
    public groupSelect(event: any) {
        if (!event || !event.select) {
            return;
        }
        if(!this.multiple) {
            this.selects = [];
        }
        if(event.rselect) {
            let index: number = this.selects.findIndex((item: any) => Object.is(event.rselect, item.id));
            if(index >= 0) {
                this.selects.splice(index, 1);
            }
        } else {
            event.select.forEach((key: string) => {
                let index: number = this.selects.findIndex((item: any) => Object.is(key, item.id));
                if(index >= 0) {
                    return;
                }
                let item: any = this.cardItems.find((item: any) => Object.is(key, item.id));
                if (item) {
                    this.selects.push(item);
                }
            });
        }
    }

    /**
     * 确认
     *
     * @type {*}
     * @memberof IBizGroupPicker
     */  
    public onOK() {
        this.$emit('close', this.selects);
    }
    
    /**
     * 取消
     *
     * @type {*}
     * @memberof IBizGroupPicker
     */  
    public onCancel() {
        this.$emit('close');
    }
}
</script>

<style lang="less">
.ibiz-group-container {
    display: flex;
    height: calc(100% - 65px);
    .ibiz-group-tree {
        width: 400px;
        border-right: 1px solid #ddd;
        padding: 0 10px;
        overflow: auto;
        height: 100%;
    }
    .ibiz-group-content {
        flex-grow: 1;
        padding: 0 10px;
        overflow: auto;
        height: 100%;
    }
}
.ibiz-group-footer {
    padding: 16px;
    text-align: right;
    border-top: 1px solid #ddd;
}
</style>