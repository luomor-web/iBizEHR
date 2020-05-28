/**
 * Main 部件模型
 *
 * @export
 * @class MainModel
 */
export default class MainModel {

  /**
  * 获取数据项集合
  *
  * @returns {any[]}
  * @memberof MainModel
  */
  public getDataItems(): any[] {
    return [
      {
        name: 'srfwfmemo',
        prop: 'srfwfmemo',
        dataType: 'TEXT',
      },
      // 前端新增修改标识，新增为"0",修改为"1"或未设值
      {
        name: 'srffrontuf',
        prop: 'srffrontuf',
        dataType: 'TEXT',
      },
      {
        name: 'srfupdatedate',
        prop: 'updatedate',
        dataType: 'DATETIME',
      },
      {
        name: 'srforikey',
      },
      {
        name: 'srfkey',
        prop: 'pimtitlecatalogueid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'pimtitlecataloguename',
        dataType: 'TEXT',
      },
      {
        name: 'srftempmode',
      },
      {
        name: 'srfuf',
      },
      {
        name: 'srfdeid',
      },
      {
        name: 'srfsourcekey',
      },
      {
        name: 'dh',
        prop: 'dh',
        dataType: 'TEXT',
      },
      {
        name: 'pimtitlecataloguename',
        prop: 'pimtitlecataloguename',
        dataType: 'TEXT',
      },
      {
        name: 'pimtitlecataloguename2',
        prop: 'pimtitlecataloguename2',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'zclc',
        prop: 'zclc',
        dataType: 'SSCODELIST',
      },
      {
        name: 'pimtitlecatalogueid',
        prop: 'pimtitlecatalogueid',
        dataType: 'GUID',
      },
      {
        name: 'pimtitlecatalogueid2',
        prop: 'pimtitlecatalogueid2',
        dataType: 'PICKUP',
      },
      {
        name: 'pimtitlecatalogue',
        prop: 'pimtitlecatalogueid',
        dataType: 'FONTKEY',
      },
    ]
  }

}