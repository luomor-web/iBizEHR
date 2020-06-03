<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ORMPostLibEditViewBase from './ormpost-lib-edit-view-base.vue';

import view_form from '@widgets/orm-post-lib/main-form/main-form.vue';

/**
 * 标准岗位设置
 *
 * @export
 * @class ORMPostLibEditView
 * @extends {ORMPostLibEditViewBase}
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
export default class ORMPostLibEditView extends ORMPostLibEditViewBase { }
</script>