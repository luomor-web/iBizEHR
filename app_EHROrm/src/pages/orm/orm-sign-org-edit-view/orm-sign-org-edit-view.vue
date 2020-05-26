<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import OrmSignOrgEditViewBase from './orm-sign-org-edit-view-base.vue';

import view_form from '@widgets/orm-sign-org/main-form/main-form.vue';

/**
 * 法人主体编辑视图
 *
 * @export
 * @class OrmSignOrgEditView
 * @extends {OrmSignOrgEditViewBase}
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
export default class OrmSignOrgEditView extends OrmSignOrgEditViewBase { }
</script>