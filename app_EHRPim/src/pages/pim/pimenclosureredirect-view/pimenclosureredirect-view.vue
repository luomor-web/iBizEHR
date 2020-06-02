<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMENCLOSURERedirectViewBase from './pimenclosureredirect-view-base.vue';


/**
 * 附件信息数据重定向视图
 *
 * @export
 * @class PIMENCLOSURERedirectView
 * @extends {PIMENCLOSURERedirectViewBase}
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
export default class PIMENCLOSURERedirectView extends PIMENCLOSURERedirectViewBase { }
</script>