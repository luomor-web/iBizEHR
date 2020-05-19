<template>
    <a class="app-column-link" @click="openLinkView($event)">
        <slot></slot>
    </a>
</template>

<script lang="ts">
import { Vue, Component,Prop } from 'vue-property-decorator';
import { Subject } from 'rxjs';
/**
 * 表格列链接
 */
@Component({
})
export default class AppColumnLink extends Vue {

    /**
     * 表格行数据
     *
     * @type {*}
     * @memberof AppColumnLink
     */
    @Prop() public data!: any;

    /**
     * 数据链接视图
     *
     * @type {*}
     * @memberof AppColumnLink
     */
    @Prop() public linkview?: any;

    /**
     * 值项名称
     *
     * @type {string}
     * @memberof AppColumnLink
     */
    @Prop() public valueitem?: string;

    /**
     * 导航上下文
     *
     * @type {*}
     * @memberof AppColumnLink
     */
    @Prop({default:{}}) public context?:any;

    /**
     * 导航参数
     *
     * @type {*}
     * @memberof AppColumnLink
     */
    @Prop({default:{}}) public viewparams?:any;

    /**
     * 应用实体主键属性名称
     *
     * @type {string}
     * @memberof AppColumnLink
     */
    @Prop() public deKeyField!:string;

    /**
     * 打开链接视图
     *
     * @memberof AppColumnLink
     */
    public openLinkView($event: any): void {
        $event.stopPropagation();
        if (!this.data || !this.valueitem || !this.data[this.valueitem]) {
            this.$Notice.error({ title: (this.$t('components.appColumnLink.error') as string), desc: (this.$t('components.appColumnLink.valueItemException') as string) });
            return;
        }
        // 公共参数处理
        let data: any = {};
        const bcancel: boolean = this.handlePublicParams(data);
        if (!bcancel) {
            return;
        }
        // 参数处理
        let _context = data.context;
        let _param = data.param;
        Object.assign(_context, { [this.deKeyField]: this.data[this.valueitem] });
        const view = JSON.parse(JSON.stringify(this.linkview));
        const viewname2: string = this.$util.srfFilePath2(view.viewname);
        view.viewname = viewname2;

        if (view.isRedirectView) {
            this.openRedirectView($event, view, data);
        } else if (Object.is(view.placement, 'INDEXVIEWTAB') || Object.is(view.placement, '')) {
            this.openIndexViewTab(view, _context, _param);
        } else if (Object.is(view.placement, 'POPOVER')) {
            this.openPopOver($event, view, _context, _param);
        } else if (Object.is(view.placement, 'POPUPMODAL')) {
            this.openPopupModal(view, _context, _param);
        } else if (view.placement.startsWith('DRAWER')) {
            this.openDrawer(view, _context, _param);
        }
    }

    /**
     * 路由模式打开视图
     *
     * @private
     * @param {string} viewpath
     * @param {*} data
     * @memberof AppColumnLink
     */
    private openIndexViewTab(view: any, context: any, param: any): void {
        const routePath = this.$viewTool.buildUpRoutePath(this.$route, this.context, view.deResParameters, view.parameters, [context] , param);
        this.$router.push(routePath);
    }

    /**
     * 模态模式打开视图
     *
     * @private
     * @param {*} view
     * @param {*} data
     * @memberof AppColumnLink
     */
    private openPopupModal(view: any, context: any, param: any): void {
        let container: Subject<any> = this.$appmodal.openModal(view, context, param);
        container.subscribe((result: any) => {
            if (!result || !Object.is(result.ret, 'OK')) {
                return;
            }
            this.openViewClose(result);
        });
    }

    /**
     * 抽屉模式打开视图
     *
     * @private
     * @param {*} view
     * @param {*} data
     * @memberof AppColumnLink
     */
    private openDrawer(view: any, context: any, param: any): void {
        let container: Subject<any> = this.$appdrawer.openDrawer(view, context, param);
        container.subscribe((result: any) => {
            if (!result || !Object.is(result.ret, 'OK')) {
                return;
            }
            this.openViewClose(result);
        });
    }

    /**
     * 气泡卡片模式打开
     *
     * @private
     * @param {*} $event
     * @param {*} view
     * @param {*} data
     * @memberof AppColumnLink
     */
    private openPopOver($event: any, view: any, context: any, param: any): void {
        let container: Subject<any> = this.$apppopover.openPop($event, view, context, param);
        container.subscribe((result: any) => {
            if (!result || !Object.is(result.ret, 'OK')) {
                return;
            }
            this.openViewClose(result);
        });
    }

    /**
     * 独立里面弹出
     *
     * @private
     * @param {string} url
     * @memberof AppColumnLink
     */
    private openPopupApp(url: string): void {
        window.open(url, '_blank');
    }

    /**
     * 打开重定向视图
     *
     * @private
     * @param {*} $event
     * @param {*} view
     * @param {*} data
     * @memberof AppColumnLink
     */
    private openRedirectView($event: any, view: any, data: any): void {
        this.$http.get(view.url, data).then((response: any) => {
            if (!response || response.status !== 200) {
                this.$Notice.error({ title: '错误', desc: '请求异常' });
            }
            if (response.status === 401) {
                return;
            }
            const { data: result } = response;

            if (result.viewparams && !Object.is(result.viewparams.srfkey, '')) {
                Object.assign(data, { srfkey: result.viewparams.srfkey });
            }

            if (Object.is(result.openmode, 'POPUPAPP') && result.url && !Object.is(result.url, '')) {
                this.openPopupApp(result.url);
            } else if (Object.is(result.openmode, 'INDEXVIEWTAB') || Object.is(result.openmode, '')) {
                // 所有数据保持在同一级
                if (data.srfparentdata) {
                    Object.assign(data, data.srfparentdata);
                    delete data.srfparentdata;
                }
                this.openIndexViewTab(view, null, data);
            } else if (Object.is(result.openmode, 'POPUPMODAL')) {
                const viewname = this.$util.srfFilePath2(result.viewname);
                const view: any = {
                    viewname: viewname,
                    title: result.title,
                    width: result.width,
                    height: result.height,
                }
                this.openPopupModal(view, null,data);
            } else if (result.openmode.startsWith('DRAWER')) {
                const viewname = this.$util.srfFilePath2(result.viewname);
                const view: any = {
                    viewname: viewname,
                    title: result.title,
                    width: result.width,
                    height: result.height,
                    placement: result.openmode,
                }
                this.openDrawer(view, null, data);
            } else if (Object.is(result.openmode, 'POPOVER')) {
                const viewname = this.$util.srfFilePath2(result.viewname);
                const view: any = {
                    viewname: viewname,
                    title: result.title,
                    width: result.width,
                    height: result.height,
                    placement: result.openmode,
                }
                this.openPopOver($event, view, null, data);
            }
        }).catch((response: any) => {
            if (!response || !response.status || !response.data) {
                this.$Notice.error({ title: '错误', desc: '系统异常！' });
                return;
            }
            if (response.status === 401) {
                return;
            }
        });
    }

    /**
     * 打开页面关闭
     *
     * @param {*} result
     * @memberof AppColumnLink
     */
    public openViewClose(result: any) {
        let item: any = {};
        if (result.datas && Array.isArray(result.datas)) {
            Object.assign(item, result.datas[0]);
        }
        console.log(item);
    }

    /**
     * 公共参数处理
     *
     * @param {*} arg
     * @returns
     * @memberof AppColumnLink
     */
    public handlePublicParams(arg: any): boolean {
        if (!this.data) {
            this.$Notice.error({ title: (this.$t('components.appColumnLink.error') as string), desc: (this.$t('components.appColumnLink.rowDataException') as string) });
            return false;
        }
        // 合并表单参数
        arg.param = JSON.parse(JSON.stringify(this.viewparams));
        arg.context = JSON.parse(JSON.stringify(this.context));
        return true;
    }



}
</script>

<style lang='less'>
@import './app-column-link.less';
</style>