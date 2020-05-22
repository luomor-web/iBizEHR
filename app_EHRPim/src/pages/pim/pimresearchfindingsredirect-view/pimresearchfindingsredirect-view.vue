<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMRESEARCHFINDINGSRedirectViewBase from './pimresearchfindingsredirect-view-base.vue';


/**
 * 科研成果数据重定向视图
 *
 * @export
 * @class PIMRESEARCHFINDINGSRedirectView
 * @extends {PIMRESEARCHFINDINGSRedirectViewBase}
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
export default class PIMRESEARCHFINDINGSRedirectView extends PIMRESEARCHFINDINGSRedirectViewBase { }
</script>