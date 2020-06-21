<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import OrmOrgEditViewBase from './orm-org-edit-view-base.vue';

import view_form from '@widgets/orm-org/main-form/main-form.vue';

/**
 * 组织信息
 *
 * @export
 * @class OrmOrgEditView
 * @extends {OrmOrgEditViewBase}
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
export default class OrmOrgEditView extends OrmOrgEditViewBase { }
</script>