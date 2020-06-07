import Vue, { CreateElement } from 'vue';
import PopperJs from 'popper.js';
import { on } from '../dom/dom';
import './app-popover.less';

import { ViewTool } from '../view-tool/view-tool';
import store from '../../store';
import i18n from '@/locale';

import { Subject } from 'rxjs';

/**
 * 悬浮窗控制器实例
 *
 * @export
 * @class AppPopover
 */
export class AppPopover {
    /**
     * 实例
     *
     * @private
     * @static
     * @memberof AppPopover
     */
    private static readonly $popover = new AppPopover();
    /**
     * vue实例
     *
     * @private
     * @type {Vue}
     * @memberof AppPopover
     */
    private vueExample!: Vue;
    /**
     * PopperJs实例
     *
     * @private
     * @type {PopperJs}
     * @memberof AppPopover
     */
    private popperExample?: PopperJs;
    /**
     * 是否显示悬浮窗
     *
     * @private
     * @type {boolean}
     * @memberof AppPopover
     */
    private showPopper: boolean = false;
    /**
     * 是否在点击空白区域时自动关闭
     *
     * @private
     * @type {boolean}
     * @memberof AppPopover
     */
    private isAutoClose: boolean = true;
    /**
     * 当前激活popver标识
     *
     * @private
     * @type {string}
     * @memberof AppPopover
     */
    private activePopoverTag?: string;

    /**
     * 返回数据
     */
    private tempResult = { ret: '' };

    /**
     * 数据传递对象
     */
    private subject: any;

    /**
     * 气泡卡片层级
     *
     * @private
     * @type {(number | null)}
     * @memberof AppPopover
     */
    private zIndex: number | null = null;

    /**
     * Creates an instance of AppPopover.
     * @memberof AppPopover
     */
    constructor() {
        if (AppPopover.$popover) {
            return AppPopover.$popover;
        }
        on(document, 'click', () => {
            if (!this.showPopper || !this.isAutoClose) {
                return;
            }
            this.destroy();
        });
    }

    /**
     * 初始化vue实例
     *
     * @private
     * @returns {void}
     * @memberof AppPopover
     */
    private initVueExample(): void {
        const div = document.createElement('div');
        document.body.appendChild(div);
        this.vueExample = new Vue({
            el: div,
            store: store,
            i18n: i18n,
            data: {
                title: null,
                content: null,
                isShow: false
            },
            render(h: CreateElement) {
                const content: any = this.content;
                const style: string = `display: ${this.isShow ? 'block' : 'none'};`;
                return <div style={style} class="el-popover el-popper panel-design-popover">
                    <el-card ref="datacard">
                        {
                            this.title ? <div slot="header" class="clearfix">
                                <span>{this.title}</span>
                                <span class="cancel" ref="cancel"><i class="fa fa-times" aria-hidden="true" style="cursor: pointer;"></i></span>
                            </div> : null
                        }
                        <div style="height:100%;">
                            {content ? content(h) : null}
                        </div>
                    </el-card>
                    <div x-arrow class="popper__arrow"></div>
                </div>;
            }
        });
        on(this.vueExample.$el, 'click', (event: any) => {
            if (Object.is(event.target.outerHTML, '<i aria-hidden="true" class="fa fa-times" style="cursor: pointer;"></i>')) {
                this.destroy();
            } else {
                event.stopPropagation();
            }
        });
    }

    /** 
     * 打开悬浮窗
     *
     * @param {MouseEvent} event 事件
     * @param {*} view 视图
     * @param {*} [context={}] 应用上下文参数
     * @param {any[]} deResParameters 关系实体参数对象
     * @param {any[]} parameters 当前应用视图参数对象
     * @param {any[]} args 多项数据
     * @param {*} data 行为参数
     * @param {string} [title] 标题
     * @param {PopperJs.Placement} [position='left'] 悬浮窗位置
     * @param {boolean} [isAutoClose=true] 是否自动关闭
     * @param {number} [width] 宽度
     * @param {number} [height] 高度
     * @returns {Subject<any>}
     * @memberof AppPopover
     */
    public openPop(event: MouseEvent, view: any, context: any = {}, data: any, title?: string, position: PopperJs.Placement = 'left', isAutoClose: boolean = true, width?: number, height?: number): Subject<any> {
        let viewdata: any = {};
        Object.assign(viewdata, JSON.parse(JSON.stringify(context)));
        this.subject = new Subject<any>();
        this.openPopover(event, (h: CreateElement) => {
            return h(view.viewname, {
                class: {
                    viewcontainer2: true,
                },
                props: {
                    viewdata: JSON.stringify(viewdata),
                    viewDefaultUsage: false,
                    viewparam:JSON.stringify(data)
                },
                on: {
                    viewdataschange: ($event: any) => this.dataChange($event),
                    close: ($event: any) => this.viewclose($event)
                },
            })
        }, view.title, undefined, false, view.width, view.height);
        return this.subject;
    }

    /**
     * 数据变化回调
     * @param $event 
     */
    public dataChange(result: any) {
        this.tempResult = { ret: '' };
        if (result && Array.isArray(result) && result.length > 0) {
            Object.assign(this.tempResult, { ret: 'OK' }, { datas: JSON.parse(JSON.stringify(result)) });
        }
        this.close();
        this.destroy();
    }

    /**
     * 视图关闭
     * @param result 
     */
    public viewclose(result: any) {
        if (result && Array.isArray(result) && result.length > 0) {
            Object.assign(this.tempResult, { datas: JSON.parse(JSON.stringify(result)) });
        }
        this.destroy();
    }

    /**
     * 关闭回调(吐值)
     */
    public close() {
        if (this.tempResult && Object.is(this.tempResult.ret, 'OK')) {
            this.subject.next(this.tempResult);
        }
    }

    /**
     * 打开悬浮窗
     *
     * @param {MouseEvent} event
     * @param {(h: CreateElement) => any} [content]
     * @param {string} [title]
     * @param {PopperJs.Placement} [position='left']
     * @param {boolean} [isAutoClose=true]
     * @param {number} [width]
     * @param {number} [height]
     * @returns {void}
     * @memberof AppPopover
     */
    public openPopover(event: any, content?: (h: CreateElement) => any, title?: string, position: PopperJs.Placement = 'left', isAutoClose: boolean = true, width?: number, height?: number): void {
        // 阻止事件冒泡

        event.stopPropagation();
        const element: Element = event.toElement || event.srcElement;
        if (element.hasAttribute('app-popover-tag')) {
            const tag: any = element.getAttribute('app-popover-tag');
            if (Object.is(this.activePopoverTag, tag)) {
                this.destroy();
                return;
            }
            this.activePopoverTag = tag;
        } else {
            const tag: string = 'app-popover-tag-' + new Date().getTime();
            element.setAttribute('app-popover-tag', tag);
            this.activePopoverTag = tag;
        }
        // if (!this.vueExample) {
        //     this.initVueExample();
        // }
        if (this.vueExample) {
            this.destroy();
        }
        this.initVueExample();
        const _element: any = this.vueExample.$el;

        const zIndex = this.vueExample.$store.getters.getZIndex();
        if (zIndex) {
            this.zIndex = zIndex + 100;
            this.vueExample.$store.commit('updateZIndex', this.zIndex);
        }
        _element.style.zIndex = this.zIndex;

        const datacard: any = this.vueExample.$refs.datacard;
        datacard.$el.style.width = width !== 0 ? width + 'px' : '240px';
        datacard.$el.getElementsByClassName('el-card__body')[0].style.height = height !== 0 ? height + 'px' : '562px';
        // if (width !== '0px' && width) {
        //     this.vueExample.$refs.datacard.$el.style.width = width;
        // } else {
        //     this.vueExample.$refs.datacard.$el.style.width = '240px';
        // }
        // if (height !== '0px' && height) {
        //     this.vueExample.$refs.datacard.$el.getElementsByClassName('el-card__body')[0].style.height = height;
        // } else {
        //     this.vueExample.$refs.datacard.$el.getElementsByClassName('el-card__body')[0].style.height = '562px';
        // }
        // this.destroy();
        // 是否可自动关闭
        this.isAutoClose = isAutoClose;
        // 更新vue实例内容
        this.vueExample.$data.title = title;
        this.vueExample.$data.content = content;
        this.vueExample.$data.isShow = true;
        this.vueExample.$forceUpdate();
        // 绘制popover
        const config: PopperJs.PopperOptions = {
            placement: position,
            onCreate: () => {
                this.showPopper = true;
            },
            onUpdate: (arg) => {
                const popper: any = arg.instance.popper;
                popper.style.display = 'none';
            },
            modifiers: {
                flip: {
                    boundariesElement: 'viewport'
                },
                preventOverflow: {
                    boundariesElement: document.getElementsByClassName('app-index')[0]
                }
            }
        };
        this.popperExample = new PopperJs(element, this.vueExample.$el, config);
        this.popperExample.update();
    }

    /**
     * 销毁popper(带回填数据)
     *
     * @memberof AppPopover
     */
    public destroy(): void {
        if (this.popperExample) {
            this.popperExample.destroy();

            if (this.zIndex) {
                const zIndex: any = this.zIndex;
                this.vueExample.$store.commit('updateZIndex', zIndex - 100);
                this.zIndex = null;
            }

            this.vueExample.$destroy();
            document.body.removeChild(this.vueExample.$el);
            this.popperExample = undefined;
            this.showPopper = false;
            this.activePopoverTag = '';
            this.vueExample.$data.isShow = false;
            this.vueExample.$forceUpdate();
        }
    }

    /**
     * 获取实例
     *
     * @static
     * @memberof AppPopover
     */
    public static getInstance() {
        return AppPopover.$popover;
    }

}