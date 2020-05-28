<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMARCHIVESLOANANDRETURNRedirectViewBase from './pimarchivesloanandreturnredirect-view-base.vue';


/**
 * 档案借阅及归还记录数据重定向视图
 *
 * @export
 * @class PIMARCHIVESLOANANDRETURNRedirectView
 * @extends {PIMARCHIVESLOANANDRETURNRedirectViewBase}
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
export default class PIMARCHIVESLOANANDRETURNRedirectView extends PIMARCHIVESLOANANDRETURNRedirectViewBase { }
</script>