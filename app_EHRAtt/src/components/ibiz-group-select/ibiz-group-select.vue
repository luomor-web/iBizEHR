<template>
    <div class="ibiz-group-select">
        <div class="ibiz-group-content">
            <span v-if="!multiple">
                {{ selectName }}
            </span>
            <template v-else v-for="(select, index) of selects">
                <div :key="index" class="ibiz-group-item">
                    {{ select.label }}
                    <i v-if="!disabled" class="el-icon-close" @click="remove(select)"></i>
                </div>
            </template>
        </div>
        <div v-if="!disabled" class="ibiz-group-open">
            <i v-if="!disabled && !multiple && selects.length > 0" class="el-icon-close" @click="remove(selects[0])"></i>
            <i class="el-icon-search" @click="openView"></i>
        </div>
    </div>
</template>

<script lang="ts">
import { Component, Vue, Prop, Watch } from 'vue-property-decorator';
import { Subject } from 'rxjs';

@Component({})
export default class IBizGroupSelect extends Vue {
    /**
     * 名称标识
     *
     * @type {*}
     * @memberof IBizGroupSelect
     */  
    @Prop() name!: string;

    /**
     * 树加载地址
     *
     * @type {*}
     * @memberof IBizGroupSelect
     */  
    @Prop() treeurl?:boolean;

    /**
     * 数据接口地址
     *
     * @type {*}
     * @memberof IBizGroupSelect
     */  
    @Prop() url!: string;

    /**
     * 多选
     *
     * @type {*}
     * @memberof IBizGroupSelect
     */  
    @Prop({default: false}) multiple?: boolean;

    /**
     * 数据对象
     *
     * @type {*}
     * @memberof IBizGroupSelect
     */  
    @Prop() data: any;

    /**
     * 过滤属性标识
     *
     * @type {*}
     * @memberof IBizGroupSelect
     */  
    @Prop() filter?: string;

    /**
     * 是否启用
     *
     * @type {*}
     * @memberof IBizGroupSelect
     */  
    @Prop() disabled?: boolean;

    /**
     * 值
     *
     * @type {*}
     * @memberof IBizGroupSelect
     */  
    @Prop() value: any;

    /**
     * 上下文参数
     *
     * @type {*}
     * @memberof IBizGroupSelect
     */  
    @Prop() context: any;

    /**
     * 关联属性
     *
     * @type {*}
     * @memberof IBizGroupSelect
     */  
    @Prop() valueitem: any;

    /**
     * 填充属性
     *
     * @type {*}
     * @memberof IBizGroupSelect
     */  
    @Prop() fillmap: any;

    /**
     * 选中项集合
     *
     * @type {*}
     * @memberof IBizGroupSelect
     */  
    protected selects: any[] = [];

    /**
     * 值变化
     *
     * @type {*}
     * @memberof IBizGroupSelect
     */  
    @Watch('value')
    onValueChange(newVal: any) {
        this.selects = [];
        if (newVal) {
            let item: any = {};
            item.label = newVal.split(',');
            if(this.valueitem) {
                item.id = this.data[this.valueitem] ? this.data[this.valueitem].split(',') : [];
            }
            if(this.fillmap) {
                for(let key in this.fillmap) {
                    item[this.fillmap[key]] = this.data[key] ? this.data[key].split(',') : [];
                }
            }
            item.label.forEach((val: string, index: number) => {
                let _item: any = {};
                for(let key in item) {
                    _item[key] = item[key][index] ? item[key][index] : null;
                }
                this.selects.push(_item)
            })
        }
    }

    /**
     * 单选时选中名称
     *
     * @type {*}
     * @memberof IBizGroupSelect
     */  
    get selectName() {
        if(this.selects.length > 0) {
            return this.selects[0].label;
        }
    }

    /**
     * 打开选择视图
     *
     * @type {*}
     * @memberof IBizGroupSelect
     */  
    public openView() {
        const view: any = {
            viewname: 'ibiz-group-picker',
            title: '分组选择'
        };
        const context: any = JSON.parse(JSON.stringify(this.context));
        let filtervalue:string = "";
        if(this.filter){
            if(this.data[this.filter]){
                filtervalue = this.data[this.filter];
            }else if(context[this.filter]){
                filtervalue = context[this.filter];
            }else{
                filtervalue = context.srforgid;
            }
        }else{
            filtervalue = context.srforgid;
        }
        const param: any = {};
        Object.assign(param, {
            showtree: this.treeurl?true:false,
            url:this.url,
            treeurl:this.treeurl,
            filtervalue: filtervalue,
            multiple: this.multiple,
            selects: this.selects
        });
        let container: Subject<any> = this.$appmodal.openModal(view, context, param);
        container.subscribe((result: any) => {
            if (!result || !Object.is(result.ret, 'OK')) {
                return;
            }
            this.openViewClose(result);
        });
    }

    /**
     * 选择视图关闭
     *
     * @type {*}
     * @memberof IBizGroupSelect
     */  
    public openViewClose(result: any) {
        this.selects = [];
        if (result.datas && result.datas.length > 0) {
            this.selects = result.datas
        }
        this.setValue()
    }

    /**
     * 数据删除
     *
     * @type {*}
     * @memberof IBizGroupSelect
     */  
    public remove(item: any) {
        this.selects.splice(this.selects.indexOf(item), 1);
        this.setValue()
    }

    /**
     * 设置值
     *
     * @type {*}
     * @memberof IBizGroupSelect
     */  
    public setValue() {
        let item: any = {};
        item[this.name] = null;
        if(this.valueitem) {
            item[this.valueitem] = null;
        }
        if(this.fillmap) {
            for(let key in this.fillmap) {
                item[key] = null;
            }
        }
        if(this.multiple) {
            this.selects.forEach((select: any) => {
                item[this.name] = item[this.name] ? `${item[this.name]},${select.label}` : select.label;
                if(this.valueitem) {
                    item[this.valueitem] = item[this.valueitem] ? `${item[this.valueitem]},${select.id}` : select.id;
                }
                if(this.fillmap) {
                    for(let key in this.fillmap) {
                        item[key] = item[key] ? `${item[key]},${select[this.fillmap[key]]}` : select[this.fillmap[key]];
                    }
                }
            });
        } else {
            item = this.selects.length > 0 ? this.selects[0] : {};
            item[this.name] = this.selects.length > 0 ? this.selects[0].label : null;
            if(this.valueitem) {
                item[this.valueitem] = this.selects.length > 0 ? this.selects[0].id : null;
            }
            if(this.fillmap) {
                for(let key in this.fillmap) {
                    item[key] = this.selects.length > 0 ? this.selects[0][this.fillmap[key]] : null;
                }
            }
        }
        for(let key in item) {
            this.$emit('formitemvaluechange', { name: key, value: item[key] });
        }
    } 
}
</script>

<style lang="less">
.ibiz-group-select {
    width: 100%;
    display: flex;
    border: 1px solid #DCDFE6;
    min-height: 32px;
    border-radius: 4px;
    .ibiz-group-content {
        flex-grow: 1;
        padding: 0 16px;
        .ibiz-group-item {
            display: inline-block;
            border: 1px solid #bbb;
            line-height: 24px;
            border-radius: 5px;
            margin-right: 5px;
            padding: 0 5px;
        }
    }
    .ibiz-group-open {
        display: flex;
        text-align: center;
        align-items: center;
        padding: 0 5px;
    }
}
.ibiz-group-select:hover {
    border-color: #108cee;
}
</style>