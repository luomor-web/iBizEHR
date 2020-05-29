<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMARMYCADRESRedirectViewBase from './pimarmycadresredirect-view-base.vue';


/**
 * 军转干部数据重定向视图
 *
 * @export
 * @class PIMARMYCADRESRedirectView
 * @extends {PIMARMYCADRESRedirectViewBase}
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
export default class PIMARMYCADRESRedirectView extends PIMARMYCADRESRedirectViewBase { }
</script>