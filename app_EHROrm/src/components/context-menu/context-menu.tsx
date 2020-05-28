class ContextMenuService {
    /**
     * 容器Dom对象
     *
     * @private
     * @memberof ContextMenuService
     */
    private container: Element | undefined;

    /**
     * Creates an instance of ContextMenuService.
     * @memberof ContextMenuService
     */
    constructor() {
        document.addEventListener('click', () => {
            this.clearContainer();
        });
    }

    /**
     * 设置容器
     *
     * @param {Element} container
     * @memberof ContextMenuService
     */
    public setContainer(container: Element) {
        if (container) {
            this.clearContainer();
            this.container = container;
        } else {
            console.error('容器Dom节点不存在');
        }
    }

    /**
     * 清楚容器
     *
     * @memberof ContextMenuService
     */
    public clearContainer() {
        if (this.container) {
            this.container.remove();
        }
    }

}

const service = new ContextMenuService();

import { Vue, Component, Provide, Prop, Emit } from 'vue-property-decorator';
import './context-menu.less';

@Component({})
export default class ContextMenu extends Vue {
    /**
     * 设置右键菜单Class
     *
     * @type {string}
     * @memberof ContextMenu
     */
    @Prop()
    public contextMenuClass?: string;
    /**
     * 设置右键菜单Style
     *
     * @type {*}
     * @memberof ContextMenu
     */
    @Prop()
    public contextMenuStyle?: any;
    /**
     * 右键菜单数据，在调用renderContent时会传回去。
     *
     * @type {*}
     * @memberof ContextMenu
     */
    @Prop()
    public data?: any;
    /**
     * 用于绘制右键菜单内容
     *
     * @type {any}
     * @memberof ContextMenu
     */
    @Prop()
    public renderContent?: any;
    /**
     * 菜单数据
     *
     * @type {any[]}
     * @memberof ContextMenu
     */
    @Prop()
    public menus?: any[]

    /**
     * 显示右键菜单
     *
     * @param {*} x x轴坐标
     * @param {*} y y轴坐标
     */
    public showContextMenu(x: number, y: number) {
        // 创建全屏覆盖容器
        const container = document.createElement('div');
        service.setContainer(container);
        container.oncontextmenu = () => {
            container.remove();
        };
        document.body.appendChild(container);
        // 创建Vue实例挂载
        const mount = document.createElement('div');
        container.appendChild(mount);
        this.renderContextMenu({
            top: y + 'px',
            left: x + 'px'
        }, mount, container);
    }

    /**
     * 绘制菜单
     *
     * @param {*} position 菜单显示位置
     * @param {*} mount Vue实例挂载
     * @param {*} container 容器
     * @returns
     */
    public renderContextMenu(position: any, mount: any, container: any) {
        const self = this;
        new Vue({
            data() {
                return {
                    menus: self.menus
                };
            },
            methods: {
                destroy($event: Event) {
                    container.remove();
                    this.$destroy();
                    $event.stopPropagation();
                },
                onContextMenu($event: any) {
                    $event.preventDefault();
                },
                renderContent() {
                    let menus;
                    if (this.menus) {
                        menus = this.menus.map((item) => {
                            let icon;
                            if (item.icon) {
                                icon = <img src={item.icon} />;
                            }
                            if (item.iconcls) {
                                icon = <i class={item.iconcls}></i>;
                            }
                            return (
                                <li class='context-menus-item' on-click={() => self.menuClick(item, self.data)}>
                                    {icon ? <div class="icon">{icon}</div> : null}
                                    <div class="text">{item.text}</div>
                                </li>
                            );
                        });
                    }
                    return <ul class='context-menus'>{menus}</ul>;
                }
            },
            render() {
                let content;
                if (self.renderContent) {
                    content = self.renderContent(self.data);
                }
                if (self.$slots.content) {
                    content = self.$slots.content;
                }
                if (this.menus) {
                    content = this.renderContent();
                }
                return (
                    <div class='context-menu-container context-menu' on-contextmenu={($event: any) => this.onContextMenu($event)} on-click={($event: Event) => this.destroy($event)}>
                        <div class='context-menu-content' style={position}>
                            {content}
                        </div>
                    </div>
                );
            }
        }).$mount(mount);
    }

    /**
     * 组件挂在完毕
     *
     * @memberof ContextMenu
     */
    public mounted() {
        const contextRef: any = this.$refs.context;
        if (contextRef) {
            contextRef.oncontextmenu = (event: MouseEvent) => {
                event.preventDefault();
                this.showContextMenu(event.clientX, event.clientY);
            };
        }
    }

    /**
     * 菜单点击
     *
     * @param {*} data
     * @memberof ContextMenu
     */
    @Emit('menu-click')
    public menuClick(item: any, data: any) { }

    /**
     * 绘制内容
     *
     * @returns
     * @memberof ContextMenu
     */
    public render() {
        return (
            <div class={'context-menu-component ' + this.contextMenuClass} style={this.contextMenuStyle} ref='context'>
                {this.$slots.default}
            </div>
        );
    }

}