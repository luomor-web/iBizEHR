<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ORMRelationEditViewBase from './ormrelation-edit-view-base.vue';

import view_form from '@widgets/orm-relation/main-form/main-form.vue';

/**
 * 组织管理关系表编辑视图
 *
 * @export
 * @class ORMRelationEditView
 * @extends {ORMRelationEditViewBase}
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
export default class ORMRelationEditView extends ORMRelationEditViewBase { }
</script>