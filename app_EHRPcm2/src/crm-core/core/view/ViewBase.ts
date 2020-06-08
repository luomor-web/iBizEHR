import { Vue, Prop, Watch } from 'vue-property-decorator';
import { Subject } from 'rxjs';

/**
 * 视图基类
 *
 * @export
 * @class ViewBase
 * @extends {Vue}
 */
export class ViewBase extends Vue {

    /**
     * 视图状态订阅对象
     *
     * @private
     * @type {Subject<{action: string, data: any}>}
     * @memberof ViewBase
     */
    protected viewState: Subject<ViewState> = new Subject();

    /**
     * 视图标识
     *
     * @type {string}
     * @memberof ViewBase
     */
    protected viewtag: string = '';

    /**
     * 当前视图上下文
     *
     * @type {*}
     * @memberof ViewBase
     */
    protected context: any = {};

    /**
     * 视图参数
     *
     * @type {*}
     * @memberof ViewBase
     */
    protected viewparams: any = {};

    /**
     * 视图默认引擎
     *
     * @protected
     * @type {*}
     * @memberof ViewBase
     */
    protected engine: any;

    /**
     * 视图打开模式
     *
     * @protected
     * @type {('DEFAULT' | 'MODAL')}
     * @memberof ViewBase
     */
    @Prop({ default: 'DEFAULT' })
    protected openMode!: 'DEFAULT' | 'MODAL';

    /**
     * 视图默认使用
     *
     * @type {boolean}
     * @memberof ViewBase
     */
    @Prop({ default: true })
    protected viewDefaultUsage!: boolean;

    /**
     * 数据视图
     *
     * @type {string}
     * @memberof ViewBase
     */
    @Prop()
    protected viewdata!: string;

    /**
     * 处理值变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof ViewBase
     */
    @Watch("viewdata")
    protected onViewData(newVal: any, oldVal: any): void {
        if (!Object.is(newVal, oldVal) && this.engine) {
            this.$nextTick(()=>{
              this.parseViewParam();
              this.engine.load();
            });
        }
    }

    /**
     * 传入视图参数
     *
     * @protected
     * @type {*}
     * @memberof ViewBase
     */
    @Prop()
    protected viewparam: any;

    /**
     * 视图参数变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof ViewBase
     */
    @Watch('viewparam', { immediate: true, deep: true })
    protected onParamData(newVal: any, oldVal: any): void {
        if (newVal) {
            for (const key in this.viewparams) {
                delete this.viewparams[key];
            }
            Object.assign(this.viewparams, JSON.parse(this.viewparam));
            this.viewParamChange(newVal, oldVal);
        }
    }

	/**
	 * 自定义视图导航上下文集合
	 *
	 * @type {*}
	 * @memberof ViewBase
	 */
    protected customViewNavContexts: any = {};

    /**
     * 自定义视图导航参数集合
     *
     * @type {*}
     * @memberof ViewBase
     */
    protected customViewParams: any = {};

    /**
     * 视图参数变更
     *
     * @protected
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof ViewBase
     */
    protected viewParamChange(newVal: any, oldVal: any): void { }

    /**
     * Vue声明周期
     *
     * @memberof ViewBase
     */
    public created() {
        const secondtag = this.$util.createUUID();
        this.$store.commit("viewaction/createdView", {
            viewtag: this.viewtag,
            secondtag: secondtag
        });
        this.viewtag = secondtag;
        this.parseViewParam();
    }

    /**
     * Vue声明周期(组件初始化完毕)
     *
     * @memberof ViewBase
     */
    public mounted() {
        this.engineInit();
        this.loadModel();
        this.$viewTool.setIndexViewParam(this.context);
        this.viewMounted();
    }

    /**
     * 视图组件挂载完毕
     *
     * @protected
     * @memberof ViewBase
     */
    protected viewMounted(): void { }

    /**
     * 销毁之前
     *
     * @memberof ViewBase
     */
    public beforeDestroy() {
        this.$store.commit("viewaction/removeView", this.viewtag);
    }

    /**
     * 是否为默认类型视图
     *
     * @protected
     * @returns {boolean}
     * @memberof ViewBase
     */
    protected isDefaultView(): boolean {
        return Object.is(this.openMode, 'DEFAULT');
    }

    /**
     * 是否为模态类型视图
     *
     * @protected
     * @returns {boolean}
     * @memberof ViewBase
     */
    protected isModalView(): boolean {
        return Object.is(this.openMode, 'MODAL');
    }

    /**
     * 引擎初始化
     *
     * @protected
     * @memberof ViewBase
     */
    protected engineInit(): void { }

    /**
     * 加载模型
     *
     * @protected
     * @returns {Promise<any>}
     * @memberof ViewBase
     */
    protected async loadModel(): Promise<any> { }

    /**
     * 解析视图参数
     *
     * @protected
     * @memberof ViewBase
     */
    protected parseViewParam(): void {
        for (const key in this.context) {
            delete this.context[key];
        }
        if (this.viewDefaultUsage) {
            //初始化视图唯一标识
            Object.assign(this.context, { srfsessionid: this.$util.createUUID() });
        }
        if (
            !this.viewDefaultUsage &&
            this.viewdata &&
            !Object.is(this.viewdata, "")
        ) {
            Object.assign(this.context, JSON.parse(this.viewdata));
            if (this.context && this.context.srfparentdename) {
                Object.assign(this.viewparams, { srfparentdename: this.context.srfparentdename });
            }
            if (this.context && this.context.srfparentkey) {
                Object.assign(this.viewparams, { srfparentkey: this.context.srfparentkey });
            }
            this.$forceUpdate()
            this.handleCustomViewData();
            return;
        }
        const path = this.$route.matched[this.$route.matched.length - 1].path;
        const keys: Array<any> = [];
        const curReg = this.$pathToRegExp.pathToRegexp(path, keys);
        const matchArray = curReg.exec(this.$route.path);
        let tempValue: Object = {};
        keys.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item.name, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
        this.$viewTool.formatRouteParams(tempValue, this.$route, this.context, this.viewparams);
        if (this.$store.getters.getAppData() && this.$store.getters.getAppData().context) {
            Object.assign(this.context, this.$store.getters.getAppData().context);
        }
    }

    /**
     * 处理自定义视图数据
     *
     * @protected
     * @memberof ViewBase
     */
    protected handleCustomViewData(): void {
        this.handleViewRes();
        if (Object.keys(this.customViewNavContexts).length > 0) {
            Object.keys(this.customViewNavContexts).forEach((item: any) => {
                let tempContext: any = {};
                let curNavContext: any = this.customViewNavContexts[item];
                this.handleCustomDataLogic(curNavContext, tempContext, item);
                Object.assign(this.context, tempContext);
            })
        }
        if (Object.keys(this.customViewParams).length > 0) {
            Object.keys(this.customViewParams).forEach((item: any) => {
                let tempParam: any = {};
                let curNavParam: any = this.customViewParams[item];
                this.handleCustomDataLogic(curNavParam, tempParam, item);
                Object.assign(this.viewparams, tempParam);
            })
        }
    }

    /**
     * 处理指定视图控制关系将父键转为父实体上下文
     *
     * @protected
     * @memberof ViewBase
     */
    protected handleViewRes(): void { }

    /**
     * 处理自定义视图数据逻辑
     *
     * @protected
     * @param {*} curNavData
     * @param {*} tempData
     * @param {string} item
     * @memberof ViewBase
     */
    protected handleCustomDataLogic(curNavData: any, tempData: any, item: string): void {
        // 直接值直接赋值
        if (curNavData.isRawValue) {
            if (Object.is(curNavData.value, "null") || Object.is(curNavData.value, "")) {
                Object.defineProperty(tempData, item, {
                    value: null,
                    writable: true,
                    enumerable: true,
                    configurable: true
                });
            } else {
                Object.defineProperty(tempData, item, {
                    value: curNavData.value,
                    writable: true,
                    enumerable: true,
                    configurable: true
                });
            }
        } else {
            // 先从导航上下文取数，没有再从导航参数（URL）取数，如果导航上下文和导航参数都没有则为null
            if (this.context[curNavData.value]) {
                Object.defineProperty(tempData, item, {
                    value: this.context[curNavData.value],
                    writable: true,
                    enumerable: true,
                    configurable: true
                });
            } else {
                if (this.viewparams[curNavData.value]) {
                    Object.defineProperty(tempData, item, {
                        value: this.viewparams[curNavData.value],
                        writable: true,
                        enumerable: true,
                        configurable: true
                    });
                } else {
                    Object.defineProperty(tempData, item, {
                        value: null,
                        writable: true,
                        enumerable: true,
                        configurable: true
                    });
                }
            }
        }
    }

    /**
     * 关闭视图
     *
     * @param {any[]} args
     * @memberof IndexBase
     */
    public closeView(args: any[]): void {
        if (!this.viewDefaultUsage) {
            this.$emit("viewdataschange", args);
            this.$emit("close");
        } else {
            this.$router.back();
        }
    }

}