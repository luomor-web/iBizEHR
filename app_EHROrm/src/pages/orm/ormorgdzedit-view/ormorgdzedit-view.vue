<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ORMORGDZEditViewBase from './ormorgdzedit-view-base.vue';

import view_form from '@widgets/orm-orgdz/main-form/main-form.vue';

/**
 * 组织地址维护编辑视图
 *
 * @export
 * @class ORMORGDZEditView
 * @extends {ORMORGDZEditViewBase}
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
export default class ORMORGDZEditView extends ORMORGDZEditViewBase { }
</script>