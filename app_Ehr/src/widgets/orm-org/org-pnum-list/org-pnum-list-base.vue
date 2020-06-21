<template>  
    <div :class="['app-list', this.items.length > 0 ? '' : 'app-list-empty' ]">
        <div v-if="items.length > 0" style="height:100%;">
            <app-org-p-num :items="items"></app-org-p-num>
        </div>
        <div v-else>
            暂无数据
        </div>
    </div>
</template>
<script lang='tsx'>
import { Vue, Component, Prop, Provide, Emit, Watch, Model,Inject } from 'vue-property-decorator';
import { CreateElement } from 'vue';
import { Subject, Subscription } from 'rxjs';
import { ControlInterface } from '@/interface/control';
import { UIActionTool,Util } from '@/utils';
import NavDataService from '@/service/app/navdata-service';
import OrmOrgService from '@/service/orm-org/orm-org-service';
import OrgPNumService from './org-pnum-list-service';



@Component({
    components: {
      
    }
})
export default class OrgPNumBase extends Vue implements ControlInterface {

    /**
     * 名称
     *
     * @type {string}
     * @memberof OrgPNumBase
     */
    @Prop() public name?: string;

    /**
     * 视图通讯对象
     *
     * @type {Subject<ViewState>}
     * @memberof OrgPNumBase
     */
    @Prop() public viewState!: Subject<ViewState>;

    /**
     * 应用上下文
     *
     * @type {*}
     * @memberof OrgPNumBase
     */
    @Prop() public context: any;

    /**
     * 视图参数
     *
     * @type {*}
     * @memberof OrgPNumBase
     */
    @Prop() public viewparams: any;

    /**
     * 视图状态事件
     *
     * @public
     * @type {(Subscription | undefined)}
     * @memberof OrgPNumBase
     */
    public viewStateEvent: Subscription | undefined;

    /**
     * 获取部件类型
     *
     * @returns {string}
     * @memberof OrgPNumBase
     */
    public getControlType(): string {
        return 'LIST'
    }



    /**
     * 计数器服务对象集合
     *
     * @type {Array<*>}
     * @memberof OrgPNumBase
     */    
    public counterServiceArray:Array<any> = [];

    /**
     * 建构部件服务对象
     *
     * @type {OrgPNumService}
     * @memberof OrgPNumBase
     */
    public service: OrgPNumService = new OrgPNumService({ $store: this.$store });

    /**
     * 实体服务对象
     *
     * @type {OrmOrgService}
     * @memberof OrgPNumBase
     */
    public appEntityService: OrmOrgService = new OrmOrgService({ $store: this.$store });
    


    /**
     * 关闭视图
     *
     * @param {any} args
     * @memberof OrgPNumBase
     */
    public closeView(args: any): void {
        let _this: any = this;
        _this.$emit('closeview', [args]);
    }

    /**
     *  计数器刷新
     *
     * @memberof OrgPNumBase
     */
    public counterRefresh(){
        const _this:any =this;
        if(_this.counterServiceArray && _this.counterServiceArray.length >0){
            _this.counterServiceArray.forEach((item:any) =>{
                if(item.refreshData && item.refreshData instanceof Function){
                    item.refreshData();
                }
            })
        }
    }


    /**
     * 获取多项数据
     *
     * @returns {any[]}
     * @memberof OrgPNumBase
     */
    public getDatas(): any[] {
        return this.selections;
    }

    /**
     * 获取单项树
     *
     * @returns {*}
     * @memberof OrgPNumBase
     */
    public getData(): any {
        return null;
    }

    /**
     * 是否默认选中第一条数据
     *
     * @type {boolean}
     * @memberof OrgPNumBase
     */
    @Prop({ default: false }) public isSelectFirstDefault!: boolean;

    /**
     * 显示处理提示
     *
     * @type {boolean}
     * @memberof OrgPNumBase
     */
    @Prop({ default: true }) public showBusyIndicator?: boolean;

    /**
     * 部件行为--create
     *
     * @type {string}
     * @memberof OrgPNumBase
     */
    @Prop() public createAction!: string;

    /**
     * 部件行为--remove
     *
     * @type {string}
     * @memberof OrgPNumBase
     */
    @Prop() public removeAction!: string;

    /**
     * 部件行为--update
     *
     * @type {string}
     * @memberof OrgPNumBase
     */
    @Prop() public updateAction!: string;

    /**
     * 部件行为--fetch
     *
     * @type {string}
     * @memberof OrgPNumBase
     */
    @Prop() public fetchAction!: string;


    /**
     * this引用
     *
     * @type {number}
     * @memberof OrgPNumBase
     */
    public thisRef: any = this;

    /**
     * 当前页
     *
     * @type {number}
     * @memberof OrgPNumBase
     */
    public curPage: number = 1;

    /**
     * 数据
     *
     * @type {any[]}
     * @memberof OrgPNumBase
     */
    public items: any[] = [];

    /**
     * 是否支持分页
     *
     * @type {boolean}
     * @memberof OrgPNumBase
     */
    public isEnablePagingBar: boolean = true;

    /**
     * 分页条数
     *
     * @type {number}
     * @memberof OrgPNumBase
     */
    public limit: number = 1000;

    /**
     * 总条数
     *
     * @type {number}
     * @memberof OrgPNumBase
     */
    public totalRecord: number = 0;

    /**
     * 加载的数据是否附加在items之后
     *
     * @type {boolean}
     * @memberof OrgPNumBase
     */
    public isAddBehind:boolean = false;

    /**
     * 排序方向
     *
     * @type {string}
     * @memberof OrgPNumBase
     */    
    public sortDir:string = '';

    /**
     * 排序字段
     *
     * @type {string}
     * @memberof OrgPNumBase
     */    
    public sortField: string = '';

    /**
     * 选中数组
     * @type {Array<any>}
     * @memberof OrgPNumBase
     */
    public selections: Array<any> = [];

     /**
     * Vue声明周期，组件挂载完毕
     *
     * @memberof OrgPNumBase
     */
    public mounted () {
        this.afterMounted();
    }

    /**
     * 执行mounted后的逻辑
     *
     * @memberof OrgPNumBase
     */
    public afterMounted () {
        this.$el.addEventListener('scroll', ()=> {
            if( this.$el.scrollTop +  this.$el.clientHeight  >=  this.$el.scrollHeight) {
                this.loadMore();
            }
        })
    }
    

    /**
     * Vue声明周期，组件创建完毕
     *
     * @memberof OrgPNumBase
     */
    public created() {
        this.afterCreated()
    }

    /**
     * 执行created后的逻辑
     *
     *  @memberof OrgPNumBase
     */    
    public afterCreated(){
        if (this.viewState) {
            this.viewStateEvent = this.viewState.subscribe(({ tag, action, data }) => {
                if (!Object.is(this.name, tag)) {
                    return;
                }
                if (Object.is(action,'load')) {
                    this.refresh(data)
                }
            });
        }
    }    

    /**
     * vue 生命周期
     *
     * @memberof OrgPNumBase
     */
    public destroyed() {
        this.afterDestroy();
    }

    /**
     * 执行destroyed后的逻辑
     *
     * @memberof OrgPNumBase
     */
    public afterDestroy() {
        if (this.viewStateEvent) {
            this.viewStateEvent.unsubscribe();
        }
    }    

    /**
    * 加载更多
    *
    * @memberof OrgPNumBase
    */
    public loadMore(){
        if(this.totalRecord>this.items.length)
        {
            this.curPage = ++this.curPage;
            this.isAddBehind = true;
            this.load({});
        }
    }

    /**
     * 刷新
     *
     * @param {*} [opt={}]
     * @memberof Main
     */
    public refresh(opt: any = {}) {
        this.curPage = 1;
        this.items = [];
        this.load(opt);
    }

    /**
     * 列表数据加载
     *
     * @public
     * @param {*} [arg={}]
     * @memberof OrgPNumBase
     */
    public load(opt: any = {}): void {
        if(!this.fetchAction){
            this.$Notice.error({ title: '错误', desc: 'AppPortletContainerView视图列表fetchAction参数未配置' });
            return;
        }        
        const arg: any = {...opt};
        const page: any = {};
        if (this.isEnablePagingBar) {
            Object.assign(page, { page: this.curPage-1, size: this.limit });
        }
        // 设置排序
        if (!Object.is(this.sortDir, '') && !Object.is(this.sortField, '')) {
          const sort: string = this.sortField+","+this.sortDir;
            Object.assign(page, { sort: sort });
        }
        Object.assign(arg, page);
        const parentdata: any = {};
        this.$emit('beforeload', parentdata);
        Object.assign(arg, parentdata);
        let tempViewParams:any = parentdata.viewparams?parentdata.viewparams:{};
        if(this.viewparams){
            Object.assign(tempViewParams,JSON.parse(JSON.stringify(this.viewparams)));
        }
        Object.assign(arg,{viewparams:tempViewParams});
        const post: Promise<any> = this.service.search(this.fetchAction, this.context?JSON.parse(JSON.stringify(this.context)):{}, arg, this.showBusyIndicator);
        post.then((response: any) => {
            if (!response || response.status !== 200) {
                if (response.errorMessage) {
                    this.$Notice.error({ title: '错误', desc: response.errorMessage });
                }
                return;
            }
            const data: any = response.data;
            if(!this.isAddBehind){
                this.items = [];
            }
            if (Object.keys(data).length > 0) {
                let datas = JSON.parse(JSON.stringify(data));
                datas.map((item: any) => {
                    Object.assign(item, { isselected: false });
                });
                this.totalRecord = response.total;
                this.items.push(...datas);
            }
            this.isAddBehind = false;
            this.$emit('load', this.items);
            if(this.isSelectFirstDefault){
                this.handleClick(this.items[0]);
            }
        }, (response: any) => {
            if (response && response.status === 401) {
                return;
            }
            this.$Notice.error({ title: '错误', desc: response.errorMessage });
        });
    }

    /**
     * 删除
     *
     * @param {any[]} datas
     * @returns {Promise<any>}
     * @memberof OrgPNumBase
     */
    public async remove(datas: any[]): Promise<any> {
        if(!this.removeAction){
            this.$Notice.error({ title: '错误', desc: 'AppPortletContainerView视图表格removeAction参数未配置' });
            return;
        }
        if (datas.length === 0) {
            return;
        }
        let dataInfo = '';
        datas.forEach((record: any, index: number) => {
            let srfmajortext = record.srfmajortext;
            if (index < 5) {
                if (!Object.is(dataInfo, '')) {
                    dataInfo += '、';
                }
                dataInfo += srfmajortext;
            } else {
                return false;
            }
        });

        if (datas.length < 5) {
            dataInfo = dataInfo + ' 共' + datas.length + '条数据';
        } else {
            dataInfo = dataInfo + '...' + ' 共' + datas.length + '条数据';
        }

        const removeData = () => {
            let keys: any[] = [];
            datas.forEach((data: any) => {
                keys.push(data.srfkey); 
            });
            let _removeAction = keys.length > 1 ? 'removeBatch' : this.removeAction ;
            const context:any = JSON.parse(JSON.stringify(this.context));
            const post: Promise<any> = this.service.delete(_removeAction,Object.assign(context,{ ormorg: keys.join(';') }),Object.assign({ ormorg: keys.join(';') },{viewparams:this.viewparams}), this.showBusyIndicator);
            return new Promise((resolve: any, reject: any) => {
                post.then((response: any) => {
                    if (!response || response.status !== 200) {
                        this.$Notice.error({ title: '', desc: '删除数据失败,' + response.info });
                        return;
                    } else {
                        this.$Notice.success({ title: '', desc: '删除成功!' });
                    }
                    //删除items中已删除的项
                    datas.forEach((data: any) => {
                      this.items.some((item:any,index:number)=>{
                        if(Object.is(item.srfkey,data.srfkey)){
                          this.items.splice(index,1);
                                return true;
                            }
                        });
                    });
                    this.$emit('remove', null);
                    this.selections = [];
                    resolve(response);
                }).catch((response: any) => {
                    if (response && response.status === 401) {
                        return;
                    }
                    if (!response || !response.status || !response.data) {
                        this.$Notice.error({ title: '错误', desc: '系统异常' });
                        reject(response);
                        return;
                    }
                    reject(response);
                });
            });
        }

        dataInfo = dataInfo.replace(/[null]/g, '').replace(/[undefined]/g, '').replace(/[ ]/g, '');
        this.$Modal.confirm({
            title: '警告',
            content: '确认要删除 ' + dataInfo + '，删除操作将不可恢复？',
            onOk: () => {
                removeData();
            },
            onCancel: () => { }
        });
        return removeData;
    }

    /**
     * 保存
     *
     * @param {*} $event
     * @returns {Promise<any>}
     * @memberof OrgPNumBase
     */
    public async save(args: any[], params?: any, $event?: any, xData?: any){
        let _this = this;
        let successItems:any = [];
        let errorItems:any = [];
        let errorMessage:any = [];
        for (const item of _this.items) {
            try {
                if(Object.is(item.rowDataState, 'create')){
                    if(!this.createAction){
                        this.$Notice.error({ title: '错误', desc: 'AppPortletContainerView视图列表createAction参数未配置' });
                    }else{
                      Object.assign(item,{viewparams:this.viewparams});
                      let response = await this.service.add(this.createAction, JSON.parse(JSON.stringify(this.context)),item, this.showBusyIndicator);
                      successItems.push(JSON.parse(JSON.stringify(response.data)));
                    }
                }else if(Object.is(item.rowDataState, 'update')){
                    if(!this.updateAction){
                        this.$Notice.error({ title: '错误', desc: 'AppPortletContainerView视图列表updateAction参数未配置' });
                    }else{
                        Object.assign(item,{viewparams:this.viewparams});
                        if(item.ormorg){
                            Object.assign(this.context,{ormorg:item.ormorg});
                        }
                        let response = await this.service.add(this.updateAction,JSON.parse(JSON.stringify(this.context)),item, this.showBusyIndicator);
                        successItems.push(JSON.parse(JSON.stringify(response.data)));
                    }
                }
            } catch (error) {
                errorItems.push(JSON.parse(JSON.stringify(item)));
                errorMessage.push(error);
            }
        }
        this.$emit('save', successItems);
        this.refresh();
        if(errorItems.length === 0){
            this.$Notice.success({ title: '', desc: '保存成功!' });
        }else{
          errorItems.forEach((item:any,index:number)=>{
            this.$Notice.error({ title: '保存失败', desc: item.majorentityname+'保存失败！' });
            console.error(errorMessage[index]);
          });
        }
        return successItems;
    }

    /**
     * 面板数据变化处理事件
     * @param {any} item 当前列数据
     * @param {any} $event 面板事件数据
     *
     * @memberof OrgPNumBase
     */
    public onPanelDataChange(item:any,$event:any) {
        Object.assign(item, $event, {rowDataState:'update'});
    }

    /**
     * 选择数据
     * @memberof OrgPNumBase
     *
     */
    public handleClick(args: any) {
        this.clearSelection();
        args.isselected = !args.isselected;
        this.selectchange();
    }

    /**
     * 双击数据
     * @memberof OrgPNumBase
     *
     */
    public handleDblClick(args: any) {
        this.$emit('rowdblclick', args);
    }

    /**
     * 触发事件
     * @memberof OrgPNumBase
     *
     */
    public selectchange() {
        this.selections = [];
        this.items.map((item: any) => {
            if (item.isselected) {
                this.selections.push(item);
            }
        });
        this.$emit('selectionchange', this.selections);
    }

    /**
     * 清除当前所有选中状态
     *
     * @memberof OrgPNumBase
     */
    public clearSelection(){
        this.items.map((item: any) => {
            Object.assign(item, { isselected: false });
        }); 
    }

}
</script>

<style lang='less'>
@import './org-pnum-list.less';
</style>