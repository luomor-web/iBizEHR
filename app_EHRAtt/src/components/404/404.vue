<template>
    <div class="app-error-view">
        <div class="app-error-container">
            <img src="/assets/img/404.png" />
            <div class="error-text">
                <div class="error-text1">{{$t('components.404.errorText1')}}</div>
                <div class="error-text2">{{$t('components.404.errorText2')}} <a @click="gotoIndexView">{{$t('components.404.indexPage')}}</a> {{$t('components.404.continue')}}</div>
            </div>
        </div>
    </div>
</template>

<script lang="ts">
import { Vue, Component } from 'vue-property-decorator';

@Component({
})
export default class Error404 extends Vue {

    /**
     * 跳转首页
     *
     * @memberof Error404
     */
    public gotoIndexView() {
        this.$router.push('/'); 
    }
}
</script>

<style lang='less'>
@import './404.less';
</style>