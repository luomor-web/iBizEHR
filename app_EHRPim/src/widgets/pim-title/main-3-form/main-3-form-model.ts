/**
 * Main_3 部件模型
 *
 * @export
 * @class Main_3Model
 */
export default class Main_3Model {

  /**
  * 获取数据项集合
  *
  * @returns {any[]}
  * @memberof Main_3Model
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
        prop: 'pimtitleid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'pimpersonname',
        dataType: 'PICKUPTEXT',
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
        name: 'pimpersonid',
        prop: 'pimpersonid',
        dataType: 'PICKUP',
      },
      {
        name: 'pimpersonname',
        prop: 'pimpersonname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'pimtitlecataloguename',
        prop: 'pimtitlecataloguename',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'zchqrq',
        prop: 'zchqrq',
        dataType: 'DATE',
      },
      {
        name: 'zcbh',
        prop: 'zcbh',
        dataType: 'TEXT',
      },
      {
        name: 'zcdj',
        prop: 'zcdj',
        dataType: 'SSCODELIST',
      },
      {
        name: 'majorengaged',
        prop: 'majorengaged',
        dataType: 'SSCODELIST',
      },
      {
        name: 'lssuingagency',
        prop: 'lssuingagency',
        dataType: 'TEXT',
      },
      {
        name: 'reviewbody',
        prop: 'reviewbody',
        dataType: 'TEXT',
      },
      {
        name: 'employtime',
        prop: 'employtime',
        dataType: 'DATE',
      },
      {
        name: 'sfzgzc',
        prop: 'sfzgzc',
        dataType: 'YESNO',
      },
      {
        name: 'jlss',
        prop: 'jlss',
        dataType: 'TEXT',
      },
      {
        name: 'fj',
        prop: 'fj',
        dataType: 'LONGTEXT_1000',
      },
      {
        name: 'pimtitlecatalogueid',
        prop: 'pimtitlecatalogueid',
        dataType: 'PICKUP',
      },
      {
        name: 'pimtitleid',
        prop: 'pimtitleid',
        dataType: 'GUID',
      },
      {
        name: 'pimtitle',
        prop: 'pimtitleid',
        dataType: 'FONTKEY',
      },
    ]
  }

}