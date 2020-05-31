<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ORMPostDetailsEditViewBase from './ormpost-details-edit-view-base.vue';

import view_form from '@widgets/orm-post-details/main-form/main-form.vue';

/**
 * 岗位明细
 *
 * @export
 * @class ORMPostDetailsEditView
 * @extends {ORMPostDetailsEditViewBase}
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
export default class ORMPostDetailsEditView extends ORMPostDetailsEditViewBase { }
</script>