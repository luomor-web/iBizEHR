<template>
  <div ref="designContainer" class="app-dashboard-design">
    <div class="design-tree">
        <el-select v-model="filterVal" clearable class="design-filter">
            <template v-for="item of groups">
                <el-option :key="item.value" :value="item.value" :label="item.name"></el-option>
            </template>
        </el-select>
        <div class="design-tree-content">
            <el-menu v-show="!filterVal" :unique-opened="true">
                <template v-for="(item, index) of list">
                    <el-submenu :key="item.type + index" :index="item.type + index">
                        <div slot="title">{{Object.is(item.type, 'app') ? $t('components.appDashboardDesign.global') : item.name}}</div>
                        <template v-for="(item2, index2) of item.children">
                            <el-submenu :key="item2.type + index2" :index="item2.type + index2">
                                <div slot="title">{{item2.name}}</div>
                                <el-menu-item ref="dragDivItem" :class="{'drag-div-item': true, 'is-disable': isDisabled(item3)}" v-for="(item3, index3) of item2.children" :key="item3.type + index3" :index="item3.type + index3" :tag="item3.portletCodeName">
                                    {{item3.portletName}}
                                </el-menu-item>
                            </el-submenu>
                        </template>
                    </el-submenu>
                </template>
            </el-menu>
            <el-menu v-show="filterVal" :unique-opened="true" :default-openeds="[filterVal]">
                <template v-for="item of groups">
                    <el-submenu v-show="filterVal == item.value" :key="item.value" :index="item.value">
                        <div slot="title">{{item.name}}</div>
                        <template v-for="item2 of item.children">
                            <el-menu-item ref="dragDivItem" :class="{'drag-div-item': true, 'is-disable': isDisabled(item2)}" :key="item2.portletCodeName" :index="item.portletCodeName" :tag="item2.portletCodeName">
                                {{item2.portletName}}
                            </el-menu-item>
                        </template>
                    </el-submenu>
                </template>
            </el-menu>
        </div>
        <div ref="dragDiv" v-if="dragItem" class="drag-tree-item">{{dragItem.caption}}</div>
    </div>
    <div class="design-panel" ref="gridLayoutPanel">
      <grid-layout
        ref="gridLayout"
        :class="['app-grid-layout', isDragEnter ? 'layout-draging': '']"
        :layout.sync="layoutModel"
        :col-num="layoutColNum"
        :row-height="layoutRowH"
        :is-draggable="true"
        :is-resizable="true"
        :is-mirrored="false"
        :vertical-compact="true"
        :margin="[10, 10]"
        :use-css-transforms="true"
		:style="{minHeight: `${10 * (layoutRowH + 10) + 10}px`}"
      >
        <div
          class="app-grid-layout-mask"
          :style="{backgroundSize: `calc((100% - 10px) / ${layoutColNum}) ${layoutRowH + 10}px`}"
        ></div>
        <grid-item
          v-for="item in layoutModel"
          class="item"
          :x="item.x"
          :y="item.y"
          :w="item.w"
          :h="item.h"
          :i="item.i"
          :key="item.i"
          v-show="!dragItem || dragItem.portletCodeName != item.portletCodeName"
        >
          <el-card class="app-grid-layout-item">
            <div slot="header">
              <span>{{item.portletName}}</span>
              <i class="el-icon-close" @click="removeItem(item.i)"></i>
            </div>
            <component :is="item.componentName"  :viewDefaultUsage="false" :context="JSON.parse(JSON.stringify(context))"></component>
          </el-card>
        </grid-item>
      </grid-layout>
    </div>
  </div>
</template>

<script lang="ts">
import { Vue, Component, Prop } from "vue-property-decorator";
import VueGridLayout from "vue-grid-layout";
import interact from "interactjs";
import AppDashboardDesignService from './app-dashboard-design-service';
import { Http } from '../../utils/http/http';
import { Subject, Subscription } from 'rxjs';

@Component({
  components: {
    GridLayout: VueGridLayout.GridLayout,
    GridItem: VueGridLayout.GridItem
  }
})
export default class AppDashboardDesign extends Vue {

    /**
     * 设计服务对象
     *
     * @protected
     * @type {AppDashboardDesignService}
     * @memberof AppDashboardDesign
     */
    protected designService: AppDashboardDesignService = new AppDashboardDesignService();

    /**
     * 应用上下文
     *
     * @type {*}
     * @memberof AppDashboardDesign
     */
    @Prop({default:{}}) context?: any;

    /**
     * 视图参数
     *
     * @type {*}
     * @memberof AppDashboardDesign
     */
    @Prop({default:{}}) viewparams?: any;

    /**
     * 视图参数
     *
     * @type {*}
     * @memberof AppDashboardDesign
     */
	@Prop() utilServiceName?: any;
	
    /**
     * 视图通讯对象
     *
     * @type {Subject<ViewState>}
     * @memberof AppDashboardDesign
     */
    @Prop() protected viewState!: Subject<ViewState>;

    /**
     * 模型对象
     *
     * @protected
     * @type {*}
     * @memberof AppDashboardDesign
     */
	protected layoutModel: any[] = [];

    /**
     * 布局列数
     *
     * @type {number}
     * @memberof AppDashboardDesign
     */
	public layoutColNum: number = 12;
	
    /**
     * 布局行高
     *
     * @type {number}
     * @memberof AppDashboardDesign
     */
	public layoutRowH: number = 80;
	
    /**
     * 拖拽对象
     *
     * @type {(any | null)}
     * @memberof AppDashboardDesign
     */
	public dragItem: any | null = null;
	
    /**
     * 是否拖拽中
     *
     * @type {boolean}
     * @memberof AppDashboardDesign
     */
	public isDragEnter: boolean = false;
	
    /**
     * 门户项列表
     *
     * @type {any[]}
     * @memberof AppDashboardDesign
     */
	public list: any[] = [];
	
    /**
     * 门户项列表
     *
     * @type {any[]}
     * @memberof AppDashboardDesign
     */
	public portlets: any[] = [];

    /**
     * 视图状态事件
     *
     * @protected
     * @type {(Subscription | undefined)}
     * @memberof AppDashboardDesign
     */
    protected viewStateEvent: Subscription | undefined;

    /**
     * 分组集合
     *
     * @type {any[]}
     * @memberof AppDashboardDesign
     */
    public groups: any[] = [];

    /**
     * 分组过滤值
     *
     * @type {string}
     * @memberof AppDashboardDesign
     */
    public filterVal: string = '';

    /**
     * 生命周期
     *
     * @memberof AppDashboardDesign
     */
    public created() {
        this.loadList();
        this.load();
        if (this.viewState) {
            this.viewStateEvent = this.viewState.subscribe(({ tag, action, data }) => {
                if (Object.is('save', action)) {
					this.save();
                }
            });
        }
    }

    /**
     * 执行destroyed后的逻辑
     *
     * @memberof AppDashboardDesign
     */
    protected afterDestroy() {
        if (this.viewStateEvent) {
            this.viewStateEvent.unsubscribe();
        }
    }

    /**
     * 加载门户列表
     *
     * @memberof AppDashboardDesign
     */
    public loadList() {
		let post = this.designService.loadPortletList(this.context, this.viewparams);
		post.then((result: any) => {
			this.portlets = result.data;
            this.list = result.result;
            this.groups = result.groups;
			this.$nextTick(() => {
				this.addEventListener();
			})
		}).catch((response: any) => {
			console.log(response);
		});
    }

    /**
     * 加载
     *
     * @memberof AppDashboardDesign
     */
	public load() {
		let post = this.designService.loadModel(this.utilServiceName, this.context, this.viewparams);
		post.then((response: any) => {
			if(response.status == 200) {
				this.layoutModel = response.data;
			}
		}).catch((response: any) => {
			console.log(response);
		});
	}

    /**
     * 保存
     *
     * @memberof AppDashboardDesign
     */
	public save() {
		let param: any = {};
		Object.assign(param, {
			model: this.layoutModel,
			...this.viewparams
		});
		let post = this.designService.saveModel(this.utilServiceName, this.context, param);
		post.then((response: any) => {
			this.$emit("save", response.data);
		}).catch((response: any) => {
			console.log(response);
		});
	}

    /**
     * 是否禁止拖动
     *
     * @param {*} item
     * @returns
     * @memberof AppDashboardDesign
     */
    public isDisabled(item: any) {
        const index: any = this.layoutModel.findIndex((a: any) =>
            Object.is(a.i, item.portletCodeName)
        );
        if (index >= 0) {
            return true;
        }
        return false;
    }

    /**
     * 删除项
     *
     * @param {string} id
     * @memberof AppDashboardDesign
     */
    public removeItem(id: string) {
        const index: any = this.layoutModel.findIndex((item: any) =>
            Object.is(item.i, id)
        );
        if (index !== -1) {
            this.layoutModel.splice(index, 1);
        }
        let item = this.portlets.find((item: any) => Object.is(item.portletCodeName, id));
        if (item) {
            item.moved = false;
        }
    }

    /**
     * 添加事件
     *
     * @memberof AppDashboardDesign
     */
	public addEventListener() {
		if (this.$refs.dragDivItem) {
			let dragDivItems: any = this.$refs.dragDivItem;
			dragDivItems.forEach((dragDivItem: any) => {
				let interactObj = interact(dragDivItem.$el);
				interactObj.draggable({});
				interactObj.on("dragstart dragmove dragend", event => {
					this.handleDrag(event);
				});
			});
		}
	}

    /**
     * 拖动
     *
     * @param {*} event
     * @returns
     * @memberof AppDashboardDesign
     */
    public handleDrag(event: any) {
        let tag = event.currentTarget.getAttribute("tag");
        let item = this.portlets.find((item: any) => Object.is(item.portletCodeName, tag));
        if (item.moved) {
            return;
        }
        switch (event.type) {
            case "dragstart": {
                if (item) {
                    this.dragItem = item;
                    let dragDiv: any = this.$refs.dragDiv;
                }
                break;
            }
            case "dragmove": {
                if (!this.dragItem) {
                    return;
                }
                let dragDiv: any = this.$refs.dragDiv;
                let mouseX = Math.round(event.client.x);
                let mouseY = Math.round(event.client.y);
                if (dragDiv) {
                    dragDiv.style.left = mouseX + "px";
                    dragDiv.style.top = mouseY + "px";
                }

                let index = this.layoutModel.findIndex(item =>
                    Object.is(item.portletCodeName, this.dragItem.portletCodeName)
                );
				let gridLayoutPanel: any = this.$refs.gridLayoutPanel;
				let gridLayout: any = this.$refs.gridLayout;
                let ctainRect = gridLayoutPanel.getBoundingClientRect();
                if (
                    mouseX > ctainRect.x &&
                    mouseX < ctainRect.x + ctainRect.width &&
                    mouseY > ctainRect.y &&
                    mouseY < ctainRect.y + ctainRect.height
                ) {
                    if (index === -1) {
                        let addItem: any = { x: 0, y: 0, w: 4, h: 3, i: this.dragItem.portletCodeName };
                        Object.assign(addItem, this.dragItem);
                        delete addItem.moved;
                        this.layoutModel.push(addItem);
                    }
                    let x = Math.round(
                        (mouseX - ctainRect.x) /
                        ((ctainRect.width - 10) / this.layoutColNum)
                    );
                    if (x >= 1) {
                        x -= 1;
                    } else {
                        0;
                    }
                    let y = Math.round((mouseY - ctainRect.y) / (this.layoutRowH + 10));
                    if (y >= 2) {
                        y -= 2;
                    } else {
                        y = 0;
                    }
                    gridLayout.dragEvent(event.type, this.dragItem.portletCodeName, x, y, 3, 4);
                    this.isDragEnter = true;
                } else {
                    if (index !== -1) {
                        gridLayout.dragEvent("dragleave", this.dragItem.portletCodeName, 0, 0, 0, 0);
                        this.layoutModel.splice(index, 1);
                    }
                    this.isDragEnter = false;
                }
                break;
            }
            case "dragend": {
                let item = this.layoutModel.find(item =>
                    Object.is(item.portletCodeName, this.dragItem.portletCodeName)
                );
                let gridLayout: any = this.$refs.gridLayout;
                if (item) {
                    this.dragItem.moved = true;
                    gridLayout.dragEvent(
                        event.type,
                        this.dragItem.portletCodeName,
                        item.x,
                        item.y,
                        item.h,
                        item.w
                    );
                }
                this.dragItem = null;
                this.isDragEnter = false;
                break;
            }
        }
    }
}
</script>

<style lang="less">
@import "./app-dashboard-design.less";
</style>