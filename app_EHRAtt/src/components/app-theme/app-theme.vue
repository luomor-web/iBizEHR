<template>
    <div class='app-theme'>
        <poptip
            :title="$t('components.appTheme.caption.theme')"
            popper-class='app-app-theme'
            placement='bottom-end'
            :width="Object.is($i18n.locale, 'zh-CN') ? 180 : 250">
            <a>
                <icon class='app-theme-icon' type='md-settings' :size="22" />
            </a>
            <template slot='content'>
                <div class='app-theme-color'>
                    <template v-for="(theme, index) in defaultThemes">
                        <tooltip :content="theme.title" :key="index">
                            <div
                                :key="index"
                                :class="{ 'active': selectTheme == theme.tag, 'app-theme-item': true }"
                                :style="{ 'background': theme.color }"
                                @click="themeChange(theme.tag)">
                            </div>
                        </tooltip>
                    </template>
                </div>
                <div>
                    <i-form label-position='left'>
                        <form-item :label="$t('components.appTheme.caption.font')">
                            <i-select
                                :value="selectFont"
                                size='small'
                                :style="{ width: Object.is($i18n.locale, 'zh-CN') ? '100px' : '130px' }"
                                @on-change="fontChange"
                                transfer>
                                <template v-for="font in fontFamilys">
                                    <i-option
                                        :value="font.value"
                                        :key="font.value">
                                        {{$t(`components.appTheme.fontFamilys.${font.label}`)}}
                                    </i-option>
                                </template>
                            </i-select>
                        </form-item>
                    </i-form>
                </div>
            </template>
        </poptip>
    </div>
</template>

<script lang = 'ts'>
import { Component, Vue } from 'vue-property-decorator';

@Component({
})
export default class AppTheme extends Vue {

    /**
     * 所选择的主题
     *
     * @type {*}
     * @memberof AppTheme
     */
    selectTheme: any = '';

    /**
     * 激活主题
     *
     * @type {*}
     * @memberof AppTheme
     */
    public activeTheme: any;

    /**
     * 主题集合
     *
     * @type {Array<any>}
     * @memberof AppTheme
     */
    defaultThemes: Array<any> = [
        {
            tag: 'app-default-theme',
            title: 'light',
            color: '#f6f6f6',
        },
        {
            title: 'Blue',
            tag: 'app_theme_blue',
            color: '#6ba1d1'
        },
        {
            title: 'Dark Blue',
            tag: 'app_theme_darkblue',
            color: '#606d80'
        }
    ];

    /**
     * 所选择的字体
     *
     * @type {*}
     * @memberof AppTheme
     */
    public selectFont: any = '';

    /**
     * 字体集合
     *
     * @memberof AppTheme
     */
    public fontFamilys = [
        {
            label: 'MicrosoftYaHei',
            value: 'Microsoft YaHei',
        },
        {
            label: 'SimHei',
            value: 'SimHei',
        },
        {
            label: 'YouYuan',
            value: 'YouYuan',
        },
    ];

    /**
     * 挂载元素事件
     *
     * @memberof AppTheme
     */
    public mounted() {
        if (localStorage.getItem('theme-class')) {
            this.selectTheme = localStorage.getItem('theme-class');
        } else {
            this.selectTheme = 'app-default-theme';
        }
        if (localStorage.getItem('font-family')) {
            this.selectFont = localStorage.getItem('font-family');
        } else {
            this.selectFont = 'Microsoft YaHei';
        }
    }

    /**
     * 主题变化
     *
     * @param {*} val
     * @memberof AppTheme
     */
    public themeChange(val: any) {
        if (!Object.is(this.activeTheme, val)) {
            this.selectTheme = val;
            localStorage.setItem('theme-class', val);
            this.$router.app.$store.commit('setCurrentSelectTheme', val);
        }
    }

    /**
     * 字体变化
     *
     * @param {*} val
     * @memberof AppTheme
     */
    public fontChange(val: any) {
        if (!Object.is(this.selectFont, val)) {
            this.selectFont = val;
            localStorage.setItem('font-family', val);
            this.$router.app.$store.commit('setCurrentSelectFont', val);
        }
    }
}
</script>

<style lang="less">
@import './app-theme.less';
</style>