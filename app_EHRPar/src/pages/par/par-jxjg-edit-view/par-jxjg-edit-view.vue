<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ParJxjgEditViewBase from './par-jxjg-edit-view-base.vue';

import view_form from '@widgets/par-jxjg/main-form/main-form.vue';

/**
 * 绩效结果编辑视图
 *
 * @export
 * @class ParJxjgEditView
 * @extends {ParJxjgEditViewBase}
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
export default class ParJxjgEditView extends ParJxjgEditViewBase { }
</script>