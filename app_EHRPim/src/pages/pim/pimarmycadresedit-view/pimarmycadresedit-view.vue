<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMARMYCADRESEditViewBase from './pimarmycadresedit-view-base.vue';

import view_form from '@widgets/pim-armycadres/admin-gredit-form-form/admin-gredit-form-form.vue';

/**
 * 军转干部编辑视图
 *
 * @export
 * @class PIMARMYCADRESEditView
 * @extends {PIMARMYCADRESEditViewBase}
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
export default class PIMARMYCADRESEditView extends PIMARMYCADRESEditViewBase { }
</script>