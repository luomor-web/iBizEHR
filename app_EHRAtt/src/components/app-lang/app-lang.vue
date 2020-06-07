<template>
  <dropdown trigger='click' @on-click="selectLang">
    <span>
        {{title}}
        <icon size='18' type='md-arrow-dropdown'></icon>
    </span>
    <dropdown-menu slot='list'>                 
      <dropdown-item v-for="(item) in localList" :name="item.type" :key="`lang-${item.type}`">{{item.name}}</dropdown-item>                    
    </dropdown-menu>
  </dropdown>
</template>
<script lang = 'ts'>
import { Component, Vue } from 'vue-property-decorator';

import { localList } from '@locale/local-list';

@Component({})
export default class AppLang extends Vue {

    /**
     * 本地语言资源
     *
     * @type {*}
     * @memberof AppLang
     */
    public localList: any[] = localList;

    /**
     * 标题
     *
     * @type {(string | null)}
     * @memberof AppLang
     */
    public title: string | null = null;

    /**
     * vue 生命周期
     *
     * @memberof AppLang
     */
    public mounted() {
        const lang: string = this.$i18n.locale;
        const local: any = this.localList.find((_local: any) => Object.is(_local.type, lang));
        this.title = local.name;
    }

    /**
     * 选择语言
     *
     * @param {*} $evnet
     * @memberof AppLang
     */
    public selectLang($evnet: any): void {
        this.$i18n.locale = $evnet;
        const local: any = this.localList.find((_local: any) => Object.is(_local.type, $evnet));
        this.title = local.name;
        localStorage.setItem('local', $evnet);
    }

}
</script>
<style lang="less">
@import './app-lang.less';
</style>