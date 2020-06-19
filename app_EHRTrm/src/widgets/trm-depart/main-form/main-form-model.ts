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
        prop: 'trmdepartid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'trmdepartname',
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
        name: 'trmdepartname',
        prop: 'trmdepartname',
        dataType: 'TEXT',
      },
      {
        name: 'tzlx',
        prop: 'tzlx',
        dataType: 'SSCODELIST',
      },
      {
        name: 'lclx',
        prop: 'lclx',
        dataType: 'SSCODELIST',
      },
      {
        name: 'nd',
        prop: 'nd',
        dataType: 'SSCODELIST',
      },
      {
        name: 'jd',
        prop: 'jd',
        dataType: 'SSCODELIST',
      },
      {
        name: 'ormorgname',
        prop: 'ormorgname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'ormorgsectorname',
        prop: 'ormorgsectorname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'tdrq',
        prop: 'tdrq',
        dataType: 'DATE',
      },
      {
        name: 'jzrq',
        prop: 'jzrq',
        dataType: 'DATE',
      },
      {
        name: 'fj',
        prop: 'fj',
        dataType: 'LONGTEXT_1000',
      },
      {
        name: 'trmdepartid',
        prop: 'trmdepartid',
        dataType: 'GUID',
      },
      {
        name: 'trmdepart',
        prop: 'trmdepartid',
        dataType: 'FONTKEY',
      },
    ]
  }

}