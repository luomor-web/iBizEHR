<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ORMQYBZWHEditViewBase from './ormqybzwhedit-view-base.vue';

import view_form from '@widgets/orm-qybzwh/main-form/main-form.vue';

/**
 * 区域标准维护编辑视图
 *
 * @export
 * @class ORMQYBZWHEditView
 * @extends {ORMQYBZWHEditViewBase}
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
export default class ORMQYBZWHEditView extends ORMQYBZWHEditViewBase { }
</script>