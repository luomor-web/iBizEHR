<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMLABOURCAMPANYRedirectViewBase from './pimlabourcampanyredirect-view-base.vue';


/**
 * 劳务派遣公司管理数据重定向视图
 *
 * @export
 * @class PIMLABOURCAMPANYRedirectView
 * @extends {PIMLABOURCAMPANYRedirectViewBase}
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
export default class PIMLABOURCAMPANYRedirectView extends PIMLABOURCAMPANYRedirectViewBase { }
</script>