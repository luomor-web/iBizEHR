/**
 * AdminEditForm_2 部件模型
 *
 * @export
 * @class AdminEditForm_2Model
 */
export default class AdminEditForm_2Model {

  /**
  * 获取数据项集合
  *
  * @returns {any[]}
  * @memberof AdminEditForm_2Model
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
        prop: 'pimarchivesid',
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
        name: 'ygbh',
        prop: 'ygbh',
        dataType: 'PICKUPDATA',
      },
      {
        name: 'dabh',
        prop: 'dabh',
        dataType: 'TEXT',
      },
      {
        name: 'ormorgname',
        prop: 'ormorgname',
        dataType: 'PICKUPDATA',
      },
      {
        name: 'ormorgname3',
        prop: 'ormorgname3',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'dabgd',
        prop: 'dabgd',
        dataType: 'TEXT',
      },
      {
        name: 'cfgh',
        prop: 'cfgh',
        dataType: 'TEXT',
      },
      {
        name: 'education',
        prop: 'education',
        dataType: 'SSCODELIST',
      },
      {
        name: 'dazt',
        prop: 'dazt',
        dataType: 'SSCODELIST',
      },
      {
        name: 'dateofbirth',
        prop: 'dateofbirth',
        dataType: 'DATE',
      },
      {
        name: 'startworkdatae',
        prop: 'startworkdatae',
        dataType: 'DATE',
      },
      {
        name: 'joinpartydate',
        prop: 'joinpartydate',
        dataType: 'DATE',
      },
      {
        name: 'bz',
        prop: 'bz',
        dataType: 'LONGTEXT_1000',
      },
      {
        name: 'fj',
        prop: 'fj',
        dataType: 'LONGTEXT_1000',
      },
      {
        name: 'ormorgid3',
        prop: 'ormorgid3',
        dataType: 'PICKUP',
      },
      {
        name: 'pimarchivesid',
        prop: 'pimarchivesid',
        dataType: 'GUID',
      },
      {
        name: 'pimarchives',
        prop: 'pimarchivesid',
        dataType: 'FONTKEY',
      },
    ]
  }

}