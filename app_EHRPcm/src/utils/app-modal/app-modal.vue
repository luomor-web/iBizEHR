<template>
        <modal 
        ref='curmodal'
        class-name='app-modal'
        v-model="isShow"
        :fullscreen="isfullscreen"
        :title="title"
        :footerHide="true"
        :maskClosable="false"
        :width="width"
        :styles="style"
        :zIndex="zIndex"
        @on-visible-change="onVisibleChange($event)">
        <component
            :is="viewname"
            class="viewcontainer2"
            :viewDefaultUsage="false"
            :viewdata="JSON.stringify(viewdata)"
            :viewparam="JSON.stringify(viewparams)"
            @viewdataschange="dataChange($event)"
            @viewdatasactivated="viewDatasActivated($event)"
            @close="close($event)"
            :ref="viewname"
            ></component>
    </modal>
</template>
<script lang="ts">
import { Vue, Component, Prop, Provide, Emit, Watch } from "vue-property-decorator";
import { Subject } from "rxjs";
@Component({
    components: {}
})
export default class AppModalCompponent extends Vue {

    /**
     * 视图UI参数
     *
     * @type {any}
     * @memberof AppModal
     */ 
    @Prop() public view !:any;

    /**
     * 视图上下文参数
     *
     * @type {any}
     * @memberof AppModal
     */ 
    @Prop({default:{}}) public viewdata?:any;

    /**
     * 视图参数
     *
     * @type {any}
     * @memberof AppModal
     */ 
    @Prop({default:{}}) public viewparams?:any;

    /**
     * 数据传递对象
     *
     * @type {any}
     * @memberof AppModal
     */ 
    public subject: null | Subject<any> = new Subject<any>();

    /**
     * 是否显示
     *
     * @type {boolean}
     * @memberof AppModal
     */
    public isShow:boolean = false;

    /**
     * 是否满屏
     *
     * @type {boolean}
     * @memberof AppModal
     */    
    public isfullscreen:boolean = false;

    /**
     * 零时结果
     *
     * @type {any}
     * @memberof AppModal
     */  
    public tempResult:any = { ret: '' };

    /**
     * 视图名称
     *
     * @type {string}
     * @memberof AppModal
     */ 
    public viewname:string = '';

    /**
     * 视图标题
     *
     * @type {string}
     * @memberof AppModal
     */ 
    public title:string = '';

    /**
     * 视图宽度
     *
     * @type {number}
     * @memberof AppModal
     */ 
    public width:number = 0;

    /**
     * 视图层级
     *
     * @type {any}
     * @memberof AppModal
     */ 
    public zIndex:any = null;

    /**
     * 视图样式
     *
     * @type {any}
     * @memberof AppModal
     */ 
    public style:any = {};

    /**
     * 获取数据传递对象
     *
     * @memberof AppModal
     */ 
    public getSubject(){
        return this.subject;
    }

    /**
     * Vue生命周期created
     *
     * @memberof AppModal
     */ 
    public  created() {
        this.viewname = this.view.viewname;
        this.title = this.view.title;
        if(this.isfullscreen){
            this.isfullscreen = true;
        }
        if ((!this.view.width || this.view.width === 0 || Object.is(this.view.width, '0px'))) {
            let width = 600;
            if (window && window.innerWidth > 100) {
                if (window.innerWidth > 100) {
                    width = window.innerWidth - 100;
                } else {
                    width = window.innerWidth;
                }
            }
            this.width = width;
        } else {
            this.width = this.view.width;
        }
        if (this.view.height && !Object.is(this.view.height, '0px')) {
            Object.assign(this.style, { height: this.view.height + 'px' });
        }
    }

    /**
     * Vue生命周期mounted
     *
     * @memberof AppModal
     */ 
    public mounted() {
        const curmodal: any = this.$refs.curmodal;
        curmodal.handleGetModalIndex = () => {
            return 0;
        };
        const zIndex = this.$store.getters.getZIndex();
        if (zIndex) {
            this.zIndex = zIndex + 100;
            this.$store.commit('updateZIndex', this.zIndex);
        }
        this.isShow = true;
    }

    /**
     * Vue生命周期beforeDestroy
     *
     * @memberof AppModal
     */ 
    public beforeDestroy() {
        if (this.zIndex) {
            const zIndex: any = this.zIndex;
            this.$store.commit('updateZIndex', zIndex - 100);
        }
    }

    /**
     * 视图关闭
     *
     * @memberof AppModal
     */ 
    public close(result: any) {
        if (result && Array.isArray(result) && result.length > 0) {
            Object.assign(this.tempResult, { ret: 'OK' }, { datas: JSON.parse(JSON.stringify(result)) });
        }
        this.isShow = false;
    }

    /**
     * 视图数据变化
     *
     * @memberof AppModal
     */ 
    public dataChange(result: any) {
        this.tempResult = { ret: '' };
        if (result && Array.isArray(result) && result.length > 0) {
            Object.assign(this.tempResult, { ret: 'OK' }, { datas: JSON.parse(JSON.stringify(result)) });
        }
    }

    /**
     * 视图数据激活
     *
     * @memberof AppModal
     */ 
    public viewDatasActivated(result: any) {
        if (result && Array.isArray(result) && result.length > 0) {
            this.close(result);
        }
    }
    
    /**
     * 模态显示隐藏切换回调
     *
     * @memberof AppModal
     */ 
    public onVisibleChange($event: any) {
        const component: any = this.$refs[this.viewname];
        if (component) {
            const { viewtag: _viewtag } = component;
            const appview = this.$store.getters['viewaction/getAppView'](_viewtag);
            if (appview && appview.viewdatachange) {
                this.isShow = true;
                const title: any = this.$t('app.tabpage.sureclosetip.title');
                const contant: any = this.$t('app.tabpage.sureclosetip.content');
                this.$Modal.confirm({
                    title: title,
                    content: contant,
                    onOk: () => {
                        this.$store.commit('viewaction/setViewDataChange', { viewtag: _viewtag, viewdatachange: false });
                        this.isShow = false;
                    },
                    onCancel: () => {
                        this.isShow = true;
                    }
                });
            } else {
                this.handleShowState($event);
            }
        }
    }

    /**
     * 处理数据，向外抛值
     *
     * @memberof AppModal
     */ 
    public handleShowState($event: any) {
        if ($event) {
            return;
        }
        if (this.subject) {
            if (this.tempResult && Object.is(this.tempResult.ret, 'OK')) {
                this.subject.next(this.tempResult);
            }
        }
        setTimeout(() => {
            document.body.removeChild(this.$el);
            this.$destroy();
            this.subject = null;
        }, 500)
    }

}
</script>
<style lang="less" scoped>
@import './app-modal.less';
</style>