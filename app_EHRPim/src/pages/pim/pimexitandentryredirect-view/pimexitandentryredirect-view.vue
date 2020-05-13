<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMEXITANDENTRYRedirectViewBase from './pimexitandentryredirect-view-base.vue';


/**
 * 出入境管理数据重定向视图
 *
 * @export
 * @class PIMEXITANDENTRYRedirectView
 * @extends {PIMEXITANDENTRYRedirectViewBase}
 */
@Component({
    components: {
    },
    beforeRouteEnter: (to: any, from: any, next: any) => {
        next((vm: any) => {
            vm.$store.commit('addCurPageViewtag', { fullPath: to.fullPath, viewtag: vm.viewtag });
        });
    },
})
export default class PIMEXITANDENTRYRedirectView extends PIMEXITANDENTRYRedirectViewBase { }
</script>