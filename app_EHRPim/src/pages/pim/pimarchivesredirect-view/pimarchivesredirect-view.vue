<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMARCHIVESRedirectViewBase from './pimarchivesredirect-view-base.vue';


/**
 * 档案信息数据重定向视图
 *
 * @export
 * @class PIMARCHIVESRedirectView
 * @extends {PIMARCHIVESRedirectViewBase}
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
export default class PIMARCHIVESRedirectView extends PIMARCHIVESRedirectViewBase { }
</script>