<template>
    <div class="ibiz-page-tag" v-if="$store.state.pageMetas.length > 0">
        <div class="move-btn move-left" @click="leftMove">
            <icon type="ios-arrow-back" />
        </div>
        <div ref="scrollBody" class="tags-body">
            <div ref="scrollChild" class="tags-container" :style="{left: styleLeft + 'px'}">
                <transition-group name="tags-transition">
                    <template v-for="(meta, index) of $store.state.pageMetas">
                        <Tag ref="tagElement" :key="index" :class="isActive(index) ? 'tag-is-active' : ''" :name="index" closable @click.native="changePage(index)" @on-close="onClose(index)">
                            <div class="tag-text">
                                <tooltip  :content="getCaption(meta.caption, meta.info)" transfer :max-width="300">
                                    <i v-if="meta.iconCls && !Object.is(meta.iconCls, '')" :class="meta.iconCls"></i>
                                    <img v-else :src="meta.imgPath" class="text-icon" />
                                    &nbsp;{{getCaption(meta.caption, meta.info)}}
                                </tooltip>
                            </div>
                        </Tag>
                    </template>
                </transition-group>
            </div>
        </div>
        <div class="move-btn move-right" @click="rightMove">
            <icon type="ios-arrow-forward" />
        </div>
        <Dropdown @on-click="doTagAction" placement="bottom-end">
            <div class="move-btn">
                <icon type="ios-close-circle-outline" />
            </div>
            <DropdownMenu slot="list">
                <template v-for="(action, index) of actions">
                    <DropdownItem :key="index" :name="action.value">{{$t(action.text)}}</DropdownItem>
                </template>
            </DropdownMenu>
        </Dropdown >
    </div >
</template>

<script lang="ts">
import { Vue, Component, Provide, Prop, Watch } from 'vue-property-decorator';
import { Environment } from '../../environments/environment';

@Component({})
export default class TabPageExp extends Vue {
    @Provide()
    public styleLeft: number = 0;

    @Provide()
    public actions: any[] = [{ text: 'app.tabpage.closeall', value: 'closeAll' }, { text: 'app.tabpage.closeother', value: 'closeOther' }];

    @Watch("$route")
    public onRouteChange(newVal: any) {
        this.moveToView(newVal);
        this.$emit('change', newVal);
    }

    public created() {
        Vue.prototype.$tabPageExp = this;
    }

    public getCaption(caption: any, info: any):any {
        return  info && !Object.is(info, '') ? `${this.$t(caption)} - ${info}` : this.$t(caption);
    }

    /**
     * 向左移动
     *
     * @memberof TabPageExp
     */
    public leftMove() {
        const scrollBody: any = this.$refs.scrollBody;
        const scrollChild: any = this.$refs.scrollChild;
        if (scrollBody && scrollChild && scrollChild.offsetWidth > scrollBody.offsetWidth) {
            if ((scrollChild.offsetWidth - scrollBody.offsetWidth + this.styleLeft) > 100) {
                this.styleLeft -= 100;
            } else {
                this.styleLeft = scrollBody.offsetWidth - scrollChild.offsetWidth;
            }
        }
    }

    /**
     * 向右移动
     *
     * @memberof TabPageExp
     */
    public rightMove() {
        if (this.styleLeft < 0) {
            if (this.styleLeft + 100 > 0) {
                this.styleLeft = 0;
            } else {
                this.styleLeft += 100;
            }
        }
    }

    /**
     * 是否选中
     *
     * @param {(string | number)} index
     * @returns
     * @memberof TabPageExp
     */
    public isActive(index: string | number) {
        const page = this.$store.state.pageTagList[index];
        if (Object.is(page.fullPath, this.$route.fullPath)) {
            return true;
        }
        return false;
    }

    /**
     * 关闭
     *
     * @param {*} event
     * @param {*} name
     * @memberof TabPageExp
     */
    public onClose(name: any) {
        const page = this.$store.getters.getPage(name);
        if (!page) {
            this.$store.commit("deletePage", name);
            this.gotoPage();
        }
        const appview = this.$store.getters['viewaction/getAppView'](page.viewtag);
        if (appview && appview.viewdatachange) {
            const title: any = this.$t('app.tabpage.sureclosetip.title');
            const content: any = this.$t('app.tabpage.sureclosetip.content');
            this.$Modal.confirm({
                title: title,
                content: content,
                onOk: () => {
                    this.$store.commit("deletePage", name);
                    this.gotoPage();
                },
                onCancel: () => {
                }
            });
        } else {
            this.$store.commit("deletePage", name);
            this.gotoPage();
        }
    }

    /**
     * 是否显示关闭
     *
     * @returns
     * @memberof TabPageExp
     */
    public isClose() {
        const pageTagList = this.$store.state.pageTagList;
        if (pageTagList.length > 1) {
            return true;
        }
        return false;
    }

    /**
     * 切换分页
     *
     * @param {*} index
     * @memberof TabPageExp
     */
    public changePage(index: any) {
        this.$store.commit("setCurPage", index);
        this.gotoPage();
    }

    /**
     * 跳转页面
     *
     * @returns
     * @memberof TabPageExp
     */
    public gotoPage() {
        const length = this.$store.state.historyPathList.length;
        if (length > 0) {
            const path = this.$store.state.historyPathList[length - 1];
            if (Object.is(path, this.$route.fullPath)) {
                return;
            }
            const index = this.$store.state.pageTagList.findIndex((page: any) => Object.is(page.fullPath, path));
            if (index >= 0) {
                const page = this.$store.state.pageTagList[index];
                this.$router.push({ path: page.path, params: page.params, query: page.query });
            }
        } else {
            let path: string | null = window.sessionStorage.getItem(Environment.AppName);
            if(path) {
                this.$router.push({path: path});
            } else {
                this.$router.push('/');
            }
        }
    }

    /**
     * 设置当前页标题
     *
     * @param {*} caption
     * @memberof TabPageExp
     */
    public setCurPageCaption(routename: string, caption: any, info: string) {
        if(!Object.is(this.$route.name, routename)) {
            return;
        }
        this.$store.commit("setCurPageCaption", { route: this.$route, caption: caption, info: info });
        setTimeout(() => {
            this.moveToView(this.$route);
        }, 1);
    }

    /**
     * 移动至指定页面标签
     *
     * @param {*} to
     * @memberof TabPageExp
     */
    public moveToView(to: any) {
        const pages: any[] = this.$store.state.pageTagList;
        let leftWidth: number = 0;
        this.$nextTick(() => {
            pages.forEach((page, index) => {
                const tag: any = this.$refs.tagElement;
                if (!tag) {
                    return ;
                }
                const el = tag[index].$el;
                if (Object.is(page.fullPath, to.fullPath)) {
                    this.setLeft(el, leftWidth);
                } else {
                    leftWidth += el.offsetWidth;
                }
            });
        });
    }

    /**
     * 设置左侧边距
     *
     * @param {{ offsetWidth: number; }} tag
     * @param {number} leftWidth
     * @memberof TabPageExp
     */
    public setLeft(tag: { offsetWidth: number; }, leftWidth: number) {
        if (tag) {
            const scrollBody: any = this.$refs.scrollBody;
            if (leftWidth < -this.styleLeft) {
                this.styleLeft = -leftWidth;
            } else if ((leftWidth + tag.offsetWidth) > (scrollBody.offsetWidth - this.styleLeft)) {
                this.styleLeft -= (leftWidth + tag.offsetWidth) - (scrollBody.offsetWidth - this.styleLeft);
            }
        }
    }

    /**
     * 执行行为操作
     *
     * @param {string} name
     * @memberof TabPageExp
     */
    public doTagAction(name: string) {
        if (Object.is(name, 'closeAll')) {
            this.$store.commit("removeAllPage");
            this.gotoPage();
        } else if (Object.is(name, 'closeOther')) {
            this.$store.commit("removeOtherPage");
            this.moveToView(this.$route);
        }
    }  
}
</script>

<style lang="less">
@import './tab-page-exp.less';
</style>
