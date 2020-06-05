<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ORMEDITIONEditViewBase from './ormeditionedit-view-base.vue';

import view_form from '@widgets/orm-edition/main-form/main-form.vue';

/**
 * 版本对照表编辑视图
 *
 * @export
 * @class ORMEDITIONEditView
 * @extends {ORMEDITIONEditViewBase}
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
export default class ORMEDITIONEditView extends ORMEDITIONEditViewBase { }
</script>