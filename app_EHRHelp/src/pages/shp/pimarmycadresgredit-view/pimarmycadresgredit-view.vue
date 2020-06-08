<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMARMYCADRESGREditViewBase from './pimarmycadresgredit-view-base.vue';

import view_form from '@widgets/pim-armycadres/gredit-form-form/gredit-form-form.vue';

/**
 * 军转干部编辑视图
 *
 * @export
 * @class PIMARMYCADRESGREditView
 * @extends {PIMARMYCADRESGREditViewBase}
 */
@Component({
    components: {
        view_form, 
    },
    beforeRouteEnter: (to: any, from: any, next: any) => {
        next((vm: any) => {
            vm.$store.commit('addCurPageViewtag', { fullPath: to.fullPath, viewtag: vm.viewtag });
        });
    },
})
export default class PIMARMYCADRESGREditView extends PIMARMYCADRESGREditViewBase { }
</script>