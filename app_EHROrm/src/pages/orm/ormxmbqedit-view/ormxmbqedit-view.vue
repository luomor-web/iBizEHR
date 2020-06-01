<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ORMXMBQEditViewBase from './ormxmbqedit-view-base.vue';

import view_form from '@widgets/orm-xmbq/main-form/main-form.vue';

/**
 * 项目标签编辑视图
 *
 * @export
 * @class ORMXMBQEditView
 * @extends {ORMXMBQEditViewBase}
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
export default class ORMXMBQEditView extends ORMXMBQEditViewBase { }
</script>